package com.honeybeedev.exclusiveprison.api.command;

import java.util.function.Consumer;

public interface CommandRegistry {
    /**
     * Register an command
     * @param separate if the command should be separate from main cmd
     */
    void newCommand(boolean separate, Consumer<CommandBuilder> consumer);
}
