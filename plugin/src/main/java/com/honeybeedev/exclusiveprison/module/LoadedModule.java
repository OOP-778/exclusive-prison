package com.honeybeedev.exclusiveprison.module;

import com.honeybeedev.exclusiveprison.api.module.PrisonModule;
import java.net.URLClassLoader;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoadedModule {

    private PrisonModule module;
    private URLClassLoader loader;
    private ModuleData data;

}
