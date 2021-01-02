package com.honeybeedev.exclusiveprison.api.command;

import com.honeybeedev.exclusiveprison.api.command.argument.ArgumentMap;
import com.honeybeedev.exclusiveprison.api.command.argument.CommandArgument;
import org.bukkit.command.CommandSender;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface CommandBuilder {
    CommandBuilder label(String label);

    CommandBuilder alias(String... alias);

    CommandBuilder subCommand(Consumer<CommandBuilder> consumer);

    <T> CommandBuilder argument(CommandArgument<T> argument);

    CommandBuilder onExecute(BiConsumer<ArgumentMap, CommandSender> onExecute);
}
