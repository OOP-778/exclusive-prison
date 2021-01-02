package com.honeybeedev.exclusiveprison.api.command.argument;

import java.util.function.Function;

public interface CommandArgument<T> {
    // Identifier of the argument
    String id();

    // Set argument identifier
    CommandArgument<T> id(String id);

    // Mapper of the argument
    // This parser can throw errors and they will be handled
    Function<String, T> parser();

    // If the argument is required
    boolean required();

    // Set if argument is required
    CommandArgument<T> required(boolean required);
}
