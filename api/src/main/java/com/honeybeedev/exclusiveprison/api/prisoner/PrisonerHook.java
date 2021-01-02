package com.honeybeedev.exclusiveprison.api.prisoner;

import com.honeybeedev.exclusiveprison.api.hooks.Hook;

public interface PrisonerHook extends Hook {
    Prisoner prisoner();
}
