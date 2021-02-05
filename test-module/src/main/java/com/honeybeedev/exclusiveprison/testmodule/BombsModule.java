package com.honeybeedev.exclusiveprison.testmodule;

import com.honeybeedev.exclusiveprison.api.command.argument.Arguments;
import com.honeybeedev.exclusiveprison.api.component.Component;
import com.honeybeedev.exclusiveprison.api.component.ComponentHandler;
import com.honeybeedev.exclusiveprison.api.key.PrisonKey;
import com.honeybeedev.exclusiveprison.api.mine.PrisonMine;
import com.honeybeedev.exclusiveprison.api.module.PrisonModule;
import com.honeybeedev.exclusiveprison.api.util.data.SerializedData;

import java.util.concurrent.TimeUnit;

public class BombsModule extends PrisonModule {

    @Override
    public void reload() {

    }

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
            .newCommand(bombsCmd -> {
                bombsCmd.named("bombs");
                bombsCmd.addArg(Arguments.string(), arg -> arg.optional(true));
                bombsCmd.addCommand(giveBuilder -> {
                   giveBuilder.named("give");
                   giveBuilder.handleExecute((sender, args) -> {
                   });
                });
            });
    }
}
