package com.honeybeedev.exclusiveprison.api.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<K, V> {

    private K key;
    private V value;

}
