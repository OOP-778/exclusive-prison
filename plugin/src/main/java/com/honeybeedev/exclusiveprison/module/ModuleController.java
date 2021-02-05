package com.honeybeedev.exclusiveprison.module;

import static com.oop.inteliframework.commons.util.StringFormat.format;

import com.honeybeedev.exclusiveprison.PluginComponent;
import com.honeybeedev.exclusiveprison.api.module.PrisonModule;
import com.oop.inteliframework.commons.util.Preconditions;
import com.oop.inteliframework.config.configuration.PlainConfig;
import com.oop.inteliframework.config.node.Node;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import lombok.SneakyThrows;

public class ModuleController implements PluginComponent {
    private final Map<String, LoadedModule> loadedModuleMap = new TreeMap<>(String::compareToIgnoreCase);

    @SneakyThrows
    public void loadModules() {
        Path modulesDirectory = plugin().getDataFolder()
            .toPath()
            .resolve("modules");

        if (!Files.exists(modulesDirectory)) {
            Files.createDirectories(modulesDirectory);
        }

        List<ModuleData> moduleDatas = new LinkedList<>();
        for (File file : modulesDirectory.toFile().listFiles()) {
            try {
                Optional<PlainConfig> optionalConfig = loadModuleConfig(file);
                Preconditions.checkArgument(optionalConfig.isPresent(), "Failed to find config");

                PlainConfig config = optionalConfig.get();
                ModuleData moduleData = new ModuleData();

                moduleData.setFile(file);

                moduleData.setName(
                    config
                        .findNodeAt("name")
                        .flatMap(Node::asValuable)
                        .map(node -> node.getAs(String.class))
                        .orElseThrow(
                            () -> new IllegalStateException("Failed to find name in config"))
                );

                moduleData.setMainClassPath(config
                    .findNodeAt("main")
                    .flatMap(Node::asValuable)
                    .map(node -> node.getAs(String.class))
                    .orElseThrow(() -> new IllegalStateException("Failed to find main in config"))
                );

                moduleData.setDescription(
                    config
                        .findNodeAt("description")
                        .flatMap(Node::asValuable)
                        .map(node -> node.getAs(String.class))
                        .orElse("Undefined")
                );

                moduleData.setVersion(
                    config
                        .findNodeAt("version")
                        .flatMap(Node::asValuable)
                        .map(node -> node.getAs(String.class))
                        .orElse("Undefined")
                );

                moduleData.setDependsOn(
                    config
                        .findNodeAt("depends")
                        .flatMap(Node::asValuable)
                        .map(node -> node.getAsListOf(String.class))
                        .orElse(new ArrayList<>())
                );

                moduleData.setRepositories(
                    config
                        .findNodeAt("repositories")
                        .flatMap(Node::asValuable)
                        .map(node -> node.getAsListOf(String.class))
                        .orElse(new ArrayList<>())
                );

                moduleData.setDependencies(
                    config
                        .findNodeAt("dependencies")
                        .flatMap(Node::asValuable)
                        .map(node -> node.getAsListOf(String.class))
                        .orElse(new ArrayList<>())
                );

                moduleDatas.add(moduleData);
            } catch (Throwable throwable) {
                logger().error("loading module {}", throwable, file.getName());
            }
        }

        // Look for cyclic dependencies
        for (ModuleData moduleData : moduleDatas) {
            Optional<ModuleData> first = moduleDatas.stream().filter(
                data -> data.getDependencies().contains(moduleData.getName()) && moduleData
                    .getDependencies().contains(data.getName()))
                .findFirst();

            first.ifPresent(module -> {
                throw new IllegalStateException(
                    format("Found that module {} depends on module {} and it depends on {}",
                        module.getName(), moduleData.getName(), module.getName()));
            });
        }

        moduleDatas.sort((data1, data2) -> {
            if (data2.getDependsOn().contains(data1.getName())) {
                return -1;
            } else if (data1.getDependsOn().contains(data2.getName())) {
                return 1;
            }

            return 0;
        });

        for (ModuleData moduleData : moduleDatas) {
            URLClassLoader urlClassLoader = loadJar(moduleData.getFile());
            Class<?> mainModuleClass = Class
                .forName(moduleData.getMainClassPath(), true, urlClassLoader);
            PrisonModule module = (PrisonModule) mainModuleClass.newInstance();

            loadedModuleMap
                .put(moduleData.getName(), new LoadedModule(module, urlClassLoader, moduleData));
            logger().log("Loaded module {}", moduleData.getName());
        }
    }

    @SneakyThrows
    private URLClassLoader loadJar(File file) {
        return new URLClassLoader(
            new URL[]{file.toURI().toURL()},
            plugin().getClass().getClassLoader()
        );
    }

    private Optional<PlainConfig> loadModuleConfig(File file) {
        try (ZipInputStream zis = new ZipInputStream(
            new FileInputStream(file))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (!entry.getName().equalsIgnoreCase("module.yml")) {
                    continue;
                }

                PlainConfig config = new PlainConfig("module.yml", zis);
                return Optional.of(config);
            }
        } catch (Throwable throwable) {
            throw new IllegalStateException("Error occurred while loading module" + file.getName(),
                throwable);
        }

        return Optional.empty();
    }
}
