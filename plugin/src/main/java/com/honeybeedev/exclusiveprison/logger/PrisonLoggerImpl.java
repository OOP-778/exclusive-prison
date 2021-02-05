package com.honeybeedev.exclusiveprison.logger;

import static com.oop.inteliframework.commons.util.StringFormat.format;

import com.honeybeedev.exclusiveprison.api.logger.PrisonLogger;
import com.honeybeedev.exclusiveprison.api.util.MessageHelper;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;

@RequiredArgsConstructor
public class PrisonLoggerImpl implements PrisonLogger, MessageHelper {

    private final String loggerName;

    @Override
    public void log(String message, Object... args) {
        print("&3[&b" + loggerName + "&3]: &f" + message, args);
    }

    @Override
    public void debug(String message, String debugGroup, Object... args) {
        print("&3[&b" + loggerName + " -> Debug&3]: Group: " + debugGroup + ": " + message, args);
    }

    @Override
    public void warn(String message, Object... args) {
        print("&3[&b" + loggerName + " -> Warn&3]: &4" + message, args);
    }

    @Override
    public void error(String message, Throwable throwable, Object... args) {
        print("&cAn error of {} type has occurred while {}: {}", format(message, args), throwable.getLocalizedMessage());
        for (StackTraceElement stackTraceElement : throwable.getStackTrace())
            print("&4- &7{}", stackTraceElement.toString());

        if (throwable.getCause() != null) {
            print(" ");
            print("&cCaused by: " + throwable.getCause().getMessage());
            for (StackTraceElement stackTraceElement : throwable.getCause().getStackTrace()) {
                print("&4- &7{}", stackTraceElement.toString());
            }
        }

    }

    private void print(String message, Object... args) {
        Bukkit.getConsoleSender().sendMessage(coloured(format(message, args)));
    }
}
