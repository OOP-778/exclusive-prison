package com.honeybeedev.exclusiveprison.api.module;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface ModuleProperties {
    // Name of the module
    String name();

    // Author of the module
    String author();

    // Version of the module
    String version();

    // Depends on modules
    String[] depends() default {};
}
