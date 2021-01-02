package com.honeybeedev.exclusiveprison.api.module.listener;

import org.bukkit.event.Listener;

public interface ListenerRegistry {
    void register(Listener ...listeners);
}
