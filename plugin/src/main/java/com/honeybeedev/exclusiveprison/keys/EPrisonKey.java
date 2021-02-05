package com.honeybeedev.exclusiveprison.keys;

import java.util.Optional;
import java.util.function.Supplier;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

@Getter
@Accessors(fluent = true)
public class EPrisonKey implements com.honeybeedev.exclusiveprison.api.key.PrisonKey {

    private final String id;
    private final String fullId;
    private final Supplier<EPrisonKey> parentSupplier;

    protected EPrisonKey(String id, Supplier<EPrisonKey> parentSupplier) {
        this.parentSupplier = parentSupplier;
        this.fullId = id;

        String[] split = StringUtils.split(id, "&");
        if (split.length != 0) {
            this.id = split[split.length - 1];
        } else {
            this.id = id;
        }
    }

    @Override
    public Optional<com.honeybeedev.exclusiveprison.api.key.PrisonKey> parent() {
        if (id.equalsIgnoreCase(fullId)) {
            return Optional.empty();
        }

        return Optional.ofNullable(parentSupplier.get());
    }
}
