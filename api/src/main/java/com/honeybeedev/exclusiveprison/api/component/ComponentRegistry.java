package com.honeybeedev.exclusiveprison.api.component;

import com.honeybeedev.exclusiveprison.api.key.PrisonKey;

public interface ComponentRegistry {
    <T, C extends Component<T>> void link(
            PrisonKey key, Class<T> to, Class<C> component,
            ComponentHandler<T, C> handler
    );
}
