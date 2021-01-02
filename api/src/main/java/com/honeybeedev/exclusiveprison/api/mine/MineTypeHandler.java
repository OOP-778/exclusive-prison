package com.honeybeedev.exclusiveprison.api.mine;

import com.honeybeedev.exclusiveprison.api.key.PrisonKey;
import com.honeybeedev.exclusiveprison.api.util.data.SerializedData;
import org.bukkit.entity.Player;

public interface MineTypeHandler<T extends PrisonMine> {
    // Called when create command is executed
    void create(String name, Player player);

    // The key of the mine type that it handles
    PrisonKey mineKey();

    // Handle data serialization
    void serialize(SerializedData data);

    // Handle data deserialization
    void deserialize(SerializedData data);

    // Check if player can enter the mine
    boolean canEnter(Player player, T mine);

    // Check if player can break the mine
    boolean canBreak(Player player, T mine);
}
