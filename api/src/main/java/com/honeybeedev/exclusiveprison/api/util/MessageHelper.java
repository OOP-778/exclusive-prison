package com.honeybeedev.exclusiveprison.api.util;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;

public interface MessageHelper {
    default TextComponent textComponent(String string) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(string);
    }

    default String coloured(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
