package com.honeybeedev.exclusiveprison.api.util.data;

public interface SerializedData {
    // Will compress the contents when saved into the database
    SerializedData applyCompression();
}
