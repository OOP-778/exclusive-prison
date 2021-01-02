package com.honeybeedev.exclusiveprison.api.component;

import com.honeybeedev.exclusiveprison.api.key.PrisonKey;
import com.honeybeedev.exclusiveprison.api.util.data.SerializedData;

public interface ComponentHandler<P, T extends Component<P>> {
    Component<P> onLoad(P holder);

    T deserialize(SerializedData data);

    void serialize(SerializedData data);

    PrisonKey componentKey();
}
