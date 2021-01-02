package com.honeybeedev.exclusiveprison.api.mine;

import com.honeybeedev.exclusiveprison.api.key.PrisonKey;

public interface MineRegistry {
    void registerMineType(PrisonKey key);

    <T extends PrisonMine> MineTypeHandler<T> handler(T mine);
}
