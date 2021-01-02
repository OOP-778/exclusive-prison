package com.honeybeedev.exclusiveprison.api.util.config;

import com.honeybeedev.exclusiveprison.api.util.config.wrappers.ConfigWrapper;

public interface Configurable {
    void load(ConfigWrapper configWrapper);
}
