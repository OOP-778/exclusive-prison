package com.honeybeedev.exclusiveprison.api.lang;

import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public interface LangElement {
    Component component();

    void send(CommandSender sender);
}
