package com.honeybeedev.exclusiveprison.api.task;

import java.util.Collection;

public interface TaskController {

    Collection<PrisonTask> runningTasks();

    TaskBuilder newBuilder();

}
