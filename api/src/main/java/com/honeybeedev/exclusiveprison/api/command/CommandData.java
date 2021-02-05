package com.honeybeedev.exclusiveprison.api.command;

import java.util.Optional;

/**
 * Used in tab completions
 */
public interface CommandData {

    /**
     * Add an object to the map
     * @param object the object that we're adding
     */
    void add(Object object);

    /**
     * Try to retrieve an object from the map
     * @param type the type of the object
     * @param <T> the type
     * @return optional object of type T
     */
    <T> Optional<T> getOfType(Class<T> type);
}
