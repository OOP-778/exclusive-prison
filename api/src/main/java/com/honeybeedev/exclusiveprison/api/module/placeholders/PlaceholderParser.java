package com.honeybeedev.exclusiveprison.api.module.placeholders;

import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public interface PlaceholderParser {
    // Key of the parser
    String key();

    // Add new children to the parser at key
    void children(String key, Consumer<PlaceholderParser> parser);

    // How long should it cache the parsed placeholders?
    void cacheFor(TimeUnit unit, long time);

    // Parse placeholder at current path and id
    void parse(String id, BiFunction<CrawlerData, StringCrawler, String> parser);

    // Map an object at current path
    // Used to avoid boilerplate code of getting an custom object later in parsing
    // If a null will be returned, it will be ignored
    void map(BiFunction<CrawlerData, StringCrawler, Object> mapper);
}
