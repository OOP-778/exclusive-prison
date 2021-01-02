package com.honeybeedev.exclusiveprison.api.logger;

public interface PrisonLogger {

    /*
    Message can contain {} for placeholders
    And args will fill it by the index
    */
    void log(String message, Object... args);


    void debug(String message, Object... args);
}
