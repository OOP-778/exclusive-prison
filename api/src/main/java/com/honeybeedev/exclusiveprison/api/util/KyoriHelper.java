package com.honeybeedev.exclusiveprison.api.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class KyoriHelper {
    public static Component textComponent(String string) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(string);
    }
}
