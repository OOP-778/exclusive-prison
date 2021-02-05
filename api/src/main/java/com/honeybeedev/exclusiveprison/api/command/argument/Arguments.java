package com.honeybeedev.exclusiveprison.api.command.argument;

import com.honeybeedev.exclusiveprison.api.command.ComponentBuilder.Argument;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public interface Arguments {
    static Argument<String> string() {
        return null;
    }

    static Argument<Number> number() {
        return null;
    }

    static Argument<Player> player() {
        return null;
    }

    static Argument<OfflinePlayer> offlinePlayer() {
        return null;
    }
}
