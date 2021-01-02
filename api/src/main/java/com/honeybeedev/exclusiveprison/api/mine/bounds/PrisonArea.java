package com.honeybeedev.exclusiveprison.api.mine.bounds;

import org.bukkit.Location;

public interface PrisonArea {
    boolean isInside(Location location);
}
