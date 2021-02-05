package com.honeybeedev.exclusiveprison.api.logger;

public interface PrisonLogger {

    /**
     * Log as INFO
     * @param message the message, can contain {} to replace with args
     * @param args the args to replace in message
     */
    void log(String message, Object... args);

    /**
     * Log as DEBUG, if debug is enabled for this group
     * @param message the message, can contain {} to replace with args
     * @param args the args to replace in message
     */
    void debug(String message, String debugGroup, Object... args);

    /**
     * Log as WARN
     * @param message the message, can contain {} to replace with args
     * @param args the args to replace in message
     */
    void warn(String message, Object... args);

    /**
     * Log an error
     * @param throwable the error
     * @param message message that comes with the error
     * @param args the args to replace in message
     */
    void error(String message, Throwable throwable, Object ...args);

}
