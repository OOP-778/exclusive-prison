package com.honeybeedev.exclusiveprison.api.key;

import java.util.Optional;

public interface KeyRegistry {
    // Find a key it's identifier
    // Can be full with :
    Optional<PrisonKey> findKey(String id);

    // Get a key by identifier
    // If not present it will create one
    PrisonKey key(String id);
}
