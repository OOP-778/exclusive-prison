package com.honeybeedev.exclusiveprison;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

public class PrisonPluginLoader extends JavaPlugin {

    private Injector injector;
    private ExclusivePrison plugin;

    @Override
    public void onLoad() {
        injector = Guice.createInjector(new ExclusivePrison());
    }

    @Override
    public void onDisable() {
        injector.getBindings().clear();
    }
}
