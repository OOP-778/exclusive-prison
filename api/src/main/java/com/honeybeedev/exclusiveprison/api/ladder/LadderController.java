package com.honeybeedev.exclusiveprison.api.ladder;

import com.honeybeedev.exclusiveprison.api.key.PrisonKey;
import com.honeybeedev.exclusiveprison.api.prisoner.Prisoner;
import com.honeybeedev.exclusiveprison.api.util.NumberWrapper;

import java.util.Optional;

public interface LadderController {
    // Get max index of the ladder object
    NumberWrapper maxIndex();

    // Get current ladder object of the prisoner
    Optional<LadderObject> current(Prisoner prisoner);

    // Get key of the controller
    // Each key should start with LADDER
    // If you're creating this controller for prestiges
    // Use LADDER&PRESTIGES&<yourname>
    // If ranks use: LADDER&RANKS&<yourname>
    // If registering custom ladder controller
    // Register under LADDER&<yourname>
    PrisonKey getKey();
}
