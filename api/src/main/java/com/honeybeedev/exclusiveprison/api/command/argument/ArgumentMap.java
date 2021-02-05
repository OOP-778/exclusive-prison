package com.honeybeedev.exclusiveprison.api.command.argument;

import java.util.Optional;

/**
 * Handles arguments when commands are executed
 */
public interface ArgumentMap {
    <T> Optional<T> getOptArg(String key);

    <T> Optional<T> getOptArg(String key, Class<T> type);

    default <T> T getArg(String key) {
        return (T) getOptArg(key).orElseThrow(() -> new IllegalStateException("Failed to find argument by " + key));
    }

    default <T> T getArg(String key, Class<T> type) {
        return (T) getOptArg(key).orElseThrow(() -> new IllegalStateException("Failed to find argument by " + key));
    }
}
