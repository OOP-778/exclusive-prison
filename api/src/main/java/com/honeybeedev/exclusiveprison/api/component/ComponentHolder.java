package com.honeybeedev.exclusiveprison.api.component;

import java.util.Optional;

public interface ComponentHolder<T> {
    <C extends Component<T>> Optional<C> component(Class<C> componentClazz);
}
