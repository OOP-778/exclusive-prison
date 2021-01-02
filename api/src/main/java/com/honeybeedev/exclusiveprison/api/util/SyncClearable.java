package com.honeybeedev.exclusiveprison.api.util;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SyncClearable<T> extends Clearable<T> {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public SyncClearable(T object) {
        super(object);
    }

    public T get() {
        try {
            lock.readLock().lock();
            return object;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void set(T object) {
        try {
            lock.writeLock().lock();
            this.object = object;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
