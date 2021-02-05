package com.honeybeedev.exclusiveprison.api.command;

import java.util.List;

/**
 * Used for tab completion
 */
@FunctionalInterface
public interface TabComplete {

    /**
     * Complete the tab
     * @param commandData all the old matched data
     * @return a list of suggestions
     */
    List<String> complete(CommandData commandData);
}
