package com.honeybeedev.exclusiveprison.api.module;

import com.google.inject.AbstractModule;
import com.honeybeedev.exclusiveprison.api.ExclusivePrison;
import com.honeybeedev.exclusiveprison.api.PrisonInjectable;
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
public abstract class PrisonModule extends AbstractModule implements PrisonInjectable {
    private PrisonLogger logger;

    private ExclusivePrison plugin;

    private File dataDirectory;

    private LangRegistry language;

    private CommandRegistry commandRegistry;

    private ComponentRegistry componentRegistry;

    private PlaceholderParser placeholderParser;

    private TaskController taskController;

    public void reload() {
    }
}
