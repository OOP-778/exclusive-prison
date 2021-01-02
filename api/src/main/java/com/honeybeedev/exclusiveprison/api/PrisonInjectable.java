package com.honeybeedev.exclusiveprison.api;

import com.google.inject.Injector;

public interface PrisonInjectable {
    default void inject(Injector injector) {
        injector.injectMembers(this);
    }

    void load();
}
