package com.honeybeedev.exclusiveprison.api.ladder;

import com.honeybeedev.exclusiveprison.api.util.NumberWrapper;

import java.util.Optional;

public interface LadderObject {
    // Index of the ladder object
    NumberWrapper index();

    // Get previous object
    Optional<LadderObject> previous();

    // Get next object
    Optional<LadderObject> next();
}
