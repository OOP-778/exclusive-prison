package com.honeybeedev.exclusiveprison.api.hooks;

import java.util.function.BiConsumer;

public interface Hookable<T> {
    <H extends T> Hooked<H> hookPre(Class<H> hookClazz, BiConsumer<H, Hooked<H>> onCall);
    <H extends T> Hooked<H> hookPost(Class<H> hookClazz, BiConsumer<H, Hooked<H>> onCall);
}
