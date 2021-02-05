package com.honeybeedev.exclusiveprison.api.module;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used for define fields that will be injected once initialized
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectField {
}
