package com.honeybeedev.exclusiveprison.module;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ModuleData {

    private String name;
    private File file;
    private String version;
    private String description;
    private List<String> dependsOn = new ArrayList<>();
    private List<String> repositories = new ArrayList<>();
    private List<String> dependencies = new ArrayList<>();
    private String mainClassPath;

}
