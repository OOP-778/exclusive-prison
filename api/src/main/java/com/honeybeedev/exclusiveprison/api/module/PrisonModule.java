package com.honeybeedev.exclusiveprison.api.module;

import com.honeybeedev.exclusiveprison.api.ExclusivePrison;
import com.honeybeedev.exclusiveprison.api.command.CommandRegistry;
import com.honeybeedev.exclusiveprison.api.component.ComponentRegistry;
import com.honeybeedev.exclusiveprison.api.lang.LangRegistry;
import com.honeybeedev.exclusiveprison.api.logger.PrisonLogger;
import com.honeybeedev.exclusiveprison.api.module.placeholders.PlaceholderParser;
import com.honeybeedev.exclusiveprison.api.task.TaskController;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.File;

@Getter
@Accessors(fluent = true)
public abstract class PrisonModule {
    @InjectField
    private PrisonLogger logger;

    @InjectField
    private ExclusivePrison plugin;

    @InjectField
    private File dataDirectory;

    @InjectField
    private LangRegistry language;

    @InjectField
    private CommandRegistry commandRegistry;

    @InjectField
    private ComponentRegistry componentRegistry;

    @InjectField
    private PlaceholderParser placeholderParser;

    @InjectField
    private TaskController taskController;

    public abstract void reload();

    public abstract void load();
}
