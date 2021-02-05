package com.honeybeedev.exclusiveprison.api.lang;

import com.honeybeedev.exclusiveprison.api.component.Component;
import org.bukkit.command.CommandSender;

public interface LangElement {
    Component component();

    void send(CommandSender sender);
}
