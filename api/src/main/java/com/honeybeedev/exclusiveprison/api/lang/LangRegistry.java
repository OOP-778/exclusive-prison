package com.honeybeedev.exclusiveprison.api.lang;

import net.kyori.adventure.text.Component;

import java.util.Optional;

public interface LangRegistry {
    LangRegistry add(String id, String element);

    LangRegistry add(String id, Component component);

    Optional<LangElement> get(String id);
}
