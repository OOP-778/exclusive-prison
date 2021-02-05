package com.honeybeedev.exclusiveprison.api.command;

import com.honeybeedev.exclusiveprison.api.command.ComponentBuilder.Command;
import java.util.function.Consumer;

/**
 * Handles registering of commands
 */
public interface CommandRegistry {
    /**
     * Register an command
     */
    void newCommand(Consumer<Command> consumer);
}
