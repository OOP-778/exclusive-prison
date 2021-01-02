package com.honeybeedev.exclusiveprison.api.module.placeholders;

import java.util.Optional;

public interface CrawlerData {
    // Try to find data by type
    <T> Optional<T> find(Class<T> type);

    // Store data
    <T> void store(T object);
}
