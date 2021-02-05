package com.honeybeedev.exclusiveprison.api.command;

import com.honeybeedev.exclusiveprison.api.command.argument.ArgumentMap;
import lombok.NonNull;
import org.bukkit.command.CommandSender;

/**
 * Used for handling command execution
 */
@FunctionalInterface
public interface CommandExecute {

    /**
     * Executes the command
     * @param executor who executed the command
     * @param map argument map that contains all the data required to execute this command
     */
    void execute(@NonNull CommandSender executor, @NonNull ArgumentMap map);
}
