package com.honeybeedev.exclusiveprison.api.task;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public interface TaskBuilder {
    // name of the task
    // If not provided it will auto-generate by your module id
    TaskBuilder name(String name);

    // Should the task repeat
    TaskBuilder repeatable(boolean repeatable);

    // Delay of the task
    // If repeatable is set, it will act as a timer
    TaskBuilder delayed(TimeUnit unit, long time);

    // Should the task run on main thread?
    TaskBuilder synced(boolean synced);

    // When task is ran
    TaskBuilder running(Consumer<PrisonTask> consumer);

    // Finish if the supplier return true
    TaskBuilder finishIf(BooleanSupplier supplier);

    // When task finished
    TaskBuilder then(Consumer<TaskBuilder> then);
}
