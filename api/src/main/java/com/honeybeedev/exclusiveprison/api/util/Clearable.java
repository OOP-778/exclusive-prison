package com.honeybeedev.exclusiveprison.api.util;

import java.util.function.Consumer;
import java.util.function.Function;

public class Clearable<T> {
    protected T object;

    public Clearable(T object) {
        this.object = object;
    }

    public void clear() {
        object = null;
    }

    public T get() {
        return object;
    }

    public void set(T object) {
        this.object = object;
    }

    public void ifPresent(Consumer<T> consumer) {
        if (object != null)
            consumer.accept(object);
    }

    public void consumeAndClear(Consumer<T> consumer) {
        if (object != null) {
            consumer.accept(object);
            object = null;
        }
    }

    public <O> O produce(Function<T, O> function) {
        if (object != null) {
            return function.apply(object);
        }

        return null;
    }
}
