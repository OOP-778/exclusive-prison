package com.honeybeedev.exclusiveprison.api.currency;

import com.honeybeedev.exclusiveprison.api.key.PrisonKey;

import java.util.Collection;
import java.util.Optional;

public interface CurrencyRegistry {
    // Get currency controller by a key
    Optional<CurrencyController> fromKey(PrisonKey key);

    // Get currency controllers whose are the parent of this key
    Collection<CurrencyController> withKey(PrisonKey key);

    /**
     * Register own currency controller
     *
     * @param currencyController the controller
     */
    void register(CurrencyController currencyController);
}
