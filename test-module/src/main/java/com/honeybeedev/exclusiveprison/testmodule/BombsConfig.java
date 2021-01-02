package com.honeybeedev.exclusiveprison.testmodule;

import com.honeybeedev.exclusiveprison.api.util.config.ConfigurableList;
import com.honeybeedev.exclusiveprison.api.util.config.ModuleConfigs;
import com.honeybeedev.exclusiveprison.api.util.config.wrappers.ConfigWrapper;

@ModuleConfigs(path = "items/*.yml")
public class BombsConfig implements ConfigurableList {

    @Override
    public void load(ConfigWrapper[] configWrapper) {

    }
}
