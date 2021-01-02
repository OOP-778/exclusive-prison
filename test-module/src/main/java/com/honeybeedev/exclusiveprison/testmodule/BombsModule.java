package com.honeybeedev.exclusiveprison.testmodule;

import com.honeybeedev.exclusiveprison.api.command.argument.def.StringArgument;
import com.honeybeedev.exclusiveprison.api.component.Component;
import com.honeybeedev.exclusiveprison.api.component.ComponentHandler;
import com.honeybeedev.exclusiveprison.api.key.PrisonKey;
import com.honeybeedev.exclusiveprison.api.mine.PrisonMine;
import com.honeybeedev.exclusiveprison.api.module.ModuleProperties;
import com.honeybeedev.exclusiveprison.api.module.PrisonModule;
import com.honeybeedev.exclusiveprison.api.util.data.SerializedData;

import java.util.concurrent.TimeUnit;

@ModuleProperties(name = "Bombs", author = "OOP-778", version = "1.0", depends = {"tools"})
public class BombsModule extends PrisonModule {
    private BombsConfig config;

    @Override
    public void load() {
        // Load language
        loadLang();

        // Load commands
        loadCommands();

        // Load components
        loadComponents();

        // Load task
        taskController()
                .newBuilder()
                .name("bombs-check-data")
                .repeatable(true)
                .synced(false)
                .delayed(TimeUnit.MINUTES, 1)
                .running(task -> {
                });
    }

    private void loadLang() {
        language()
                .add("wfafawfw", "wfafawawfafawf")
                .add("wfafawawf", "fawfafwa");
    }

    private void loadComponents() {
        componentRegistry()
                .link(
                        PrisonKey.of("BombsMineModule"),
                        PrisonMine.class,
                        SampleMineComponent.class,
                        new ComponentHandler<PrisonMine, SampleMineComponent>() {
                            @Override
                            public Component<PrisonMine> onLoad(PrisonMine holder) {
                                return new SampleMineComponent(holder);
                            }

                            @Override
                            public SampleMineComponent deserialize(SerializedData data) {
                                return null;
                            }

                            @Override
                            public void serialize(SerializedData data) {
                                data.applyCompression();
                            }

                            @Override
                            public PrisonKey componentKey() {
                                return PrisonKey.of("BombsMineModule");
                            }
                        }
                );
    }

    private void loadCommands() {
        commandRegistry()
                .newCommand(false, bombsCmd -> {
                    bombsCmd.label("bombs");
                    bombsCmd.argument(
                            new StringArgument()
                                    .id("bomb")
                                    .required(true)
                    );
                    bombsCmd.onExecute((args, sender) -> {
                        String bomb = args.getArg("bomb", String.class);

                    });
                });
    }
}
