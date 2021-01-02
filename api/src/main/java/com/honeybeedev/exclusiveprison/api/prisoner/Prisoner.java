package com.honeybeedev.exclusiveprison.api.prisoner;

import com.honeybeedev.exclusiveprison.api.component.ComponentHolder;
import com.honeybeedev.exclusiveprison.api.hooks.Hookable;

import java.util.UUID;

public interface Prisoner extends ComponentHolder<Prisoner>, Hookable<PrisonerHook> {
    UUID uuid();
}
