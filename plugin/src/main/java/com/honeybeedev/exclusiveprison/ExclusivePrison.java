package com.honeybeedev.exclusiveprison;

import com.google.inject.AbstractModule;
import com.honeybeedev.exclusiveprison.keys.EPKeyRegistry;
import com.honeybeedev.exclusiveprison.api.util.Clearable;

public class ExclusivePrison extends AbstractModule {
    private Clearable<EPKeyRegistry> keyRegistry = new Clearable<>(new EPKeyRegistry());
    private ExclusivePrison prison;

    protected void load() {
        this.prison = new ExclusivePrison();

        // Bind plugin
        bind(ExclusivePrison.class)
                .toInstance(prison);

        // Bind Key Registry
        bind(EPKeyRegistry.class)
                .toInstance(keyRegistry.get());
    }

    protected void onDisable() {
        this.prison.onDisable();
    }
}
