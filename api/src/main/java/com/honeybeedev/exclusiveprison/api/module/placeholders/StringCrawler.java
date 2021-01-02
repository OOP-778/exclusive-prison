package com.honeybeedev.exclusiveprison.api.module.placeholders;

import java.util.Optional;

public interface StringCrawler {
    // Get next at the stack
    // It will increment the current index
    // Will return null if not present
    Optional<String> next();

    // Will try to peek for next value
    // It will not increment the index
    Optional<String> peek();

    // If the stack has next values
    boolean hasNext();

    // Get value at current index
    String current();

    // Move index back by one
    void back();
}
