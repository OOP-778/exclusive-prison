package com.honeybeedev.exclusiveprison;

import com.honeybeedev.exclusiveprison.api.logger.PrisonLogger;

public interface PluginComponent {

    default ExclusivePrisonPlugin plugin() {
        return ExclusivePrisonPlugin.get();
    }

    default PrisonLogger logger() {
        return plugin().getPluginLogger();
    }

}
