package com.honeybeedev.exclusiveprison.keys;

import com.honeybeedev.exclusiveprison.api.key.PrisonKey;
import com.honeybeedev.exclusiveprison.api.util.SyncClearable;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class EPKeyRegistry implements com.honeybeedev.exclusiveprison.api.key.KeyRegistry {
    private final SyncClearable<Map<String, EPKeyRegistry>> subRegistries = new SyncClearable<>(new TreeMap<>(String.CASE_INSENSITIVE_ORDER));
    private final SyncClearable<Map<String, EPrisonKey>> keys = new SyncClearable<>(new TreeMap<>(String.CASE_INSENSITIVE_ORDER));

    public Optional<PrisonKey> findKey(String key) {
        if (key.contains(":")) {
            Queue<String> keysQueue = new LinkedList<>(Arrays.asList(StringUtils.split(key, ":")));
            return _findKey(keysQueue);
        }

        return Optional.ofNullable(keys.produce(map -> map.get(key)));
    }

    public EPrisonKey key(String key) {
        if (key.contains(":")) {
            Queue<String> keysQueue = new LinkedList<>(Arrays.asList(StringUtils.split(key, ":")));
            return _key(keysQueue);
        }

        return keys.produce(map -> map.computeIfAbsent(key, key2 -> new EPrisonKey()));
    }

    private EPrisonKey _key(Queue<String> queue) {

    }

    private Optional<PrisonKey> _findKey(Queue<String> queue) {
        if (queue.isEmpty()) return Optional.empty();

        String poll = queue.poll();
        EPKeyRegistry possibleRegistry = subRegistries.produce(map -> map.get(poll));
        if (possibleRegistry != null)
            return possibleRegistry._findKey(queue);

        if (!queue.isEmpty()) return Optional.empty();

        EPrisonKey possibleKey = keys.produce(map -> map.get(poll));
        return Optional.ofNullable(possibleKey);
    }
}
