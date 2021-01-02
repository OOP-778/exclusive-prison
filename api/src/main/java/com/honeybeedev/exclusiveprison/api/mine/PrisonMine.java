package com.honeybeedev.exclusiveprison.api.mine;

import com.honeybeedev.exclusiveprison.api.component.ComponentHolder;
import com.honeybeedev.exclusiveprison.api.hooks.Hookable;
import com.honeybeedev.exclusiveprison.api.key.PrisonKey;
import com.honeybeedev.exclusiveprison.api.mine.bounds.PrisonArea;

import java.util.Optional;
import java.util.Set;

public interface PrisonMine extends ComponentHolder<PrisonMine>, Hookable<MineHook> {
    String getName();

    Set<PrisonArea> getAreas();

    Optional<PrisonArea> getAreaOf(PrisonKey key);
}
