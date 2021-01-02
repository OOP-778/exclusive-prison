package com.honeybeedev.exclusiveprison.api.ladder;

import com.honeybeedev.exclusiveprison.api.key.PrisonKey;

import java.util.Collection;
import java.util.Optional;

public interface LadderRegistry {
    // Get prestiges controller
    LadderController prestiges();

    // Get ranks controller
    LadderController ranks();

    // Get ladder controller by a key
    Optional<LadderController> fromKey(PrisonKey key);

    // Get ladder controllers whose are the parent of this key
    Collection<LadderController> withKey(PrisonKey key);

    /**
     * Register own ladder rank
     *
     * @param ladderController the controller
     */
    void register(LadderController ladderController);
}
