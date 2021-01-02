package com.honeybeedev.exclusiveprison.api.hooks;

import java.util.concurrent.TimeUnit;

public interface Hooked<T> {
    void expire();

    void expireAfter(TimeUnit unit, long time);
}
