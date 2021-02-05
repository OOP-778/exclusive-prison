package com.honeybeedev.exclusiveprison.api.command;

import java.util.function.Consumer;
import java.util.function.Function;
import lombok.NonNull;

/**
 * Handles building of commands
 */
public interface ComponentBuilder {
    interface CommonComponent {

        /**
         * The name of the component
         *
         * @return the name of the component
         */
        ComponentBuilder named(String label);
    }

    interface Command extends CommonComponent {

        /**
         * Used to handle the execution of the command
         * @param commandExecute execution handler
         */
        Command handleExecute(CommandExecute commandExecute);

        Command addCommand(Consumer<Command> commandBuilder);

        <T extends Argument> Command addArg(T argument, Consumer<T> argumentBuilderConsumer);

        Command addArg(Consumer<Argument> consumer);
    }

    interface Argument<T> extends CommonComponent {

        /**
         * Handle tab completion at the place of the argument
         *
         * @param complete handler for the completion
         */
        Argument<T> handleTabComplete(@NonNull TabComplete complete);

        /**
         * Parse input into object
         *
         * @param parser function which parses string into object
         */
        Argument<T> parse(Function<String, ParseResult<T>> parser);

        /**
         * Should the argument be optional? Remember that optional arguments should be last
         *
         * @param optional if the argument should be optional
         */
        Argument<T> optional(boolean optional);
    }
}
