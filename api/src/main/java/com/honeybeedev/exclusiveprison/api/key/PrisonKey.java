package com.honeybeedev.exclusiveprison.api.key;

import com.honeybeedev.exclusiveprison.api.ExclusivePrisonAPI;

import java.util.Optional;

public interface PrisonKey {
    // Identifier the key
    String id();

    // Full key given on initialization
    String fullId();

    // Parent of this key
    Optional<PrisonKey> parent();

    static PrisonKey of(String id) {
        return ExclusivePrisonAPI.getPlugin()
                .keyRegistry()
                .key(id);
    }
}
