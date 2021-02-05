package com.honeybeedev.exclusiveprison;

import com.honeybeedev.exclusiveprison.api.logger.PrisonLogger;
import com.honeybeedev.exclusiveprison.api.util.MessageHelper;
import com.honeybeedev.exclusiveprison.logger.PrisonLoggerImpl;
import com.honeybeedev.exclusiveprison.module.ModuleController;
import com.oop.inteliframework.commons.util.Preconditions;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class ExclusivePrisonPlugin extends JavaPlugin implements MessageHelper {

    private static ExclusivePrisonPlugin plugin;
    private final PrisonLogger pluginLogger;

    private ModuleController moduleController;

    public ExclusivePrisonPlugin() {
        Preconditions.checkArgument(plugin == null, "Plugin failed to unload!");
        plugin = this;

        this.pluginLogger = new PrisonLoggerImpl("EP");
    }

    public static ExclusivePrisonPlugin get() {
        return plugin;
    }

    private void printArt() {
        Bukkit.getConsoleSender()
            .sendMessage(coloured("&b                     \n" + "                     \n" +
                "  &b    _/_/_/_/  _/_/_/     \n" +
                "  &b   _/        _/    _/    &3Version: &e" + getDescription().getVersion() + "\n"
                +
                "  &b  _/_/_/    _/_/_/       &3Author: &eHoneyBeeDevelopment\n" +
                "  &b _/        _/            &3Software: &e" + Bukkit.getVersion() + "\n" +
                "  &b_/_/_/_/  _/         \n" +
                "  &b                     \n"));
    }

    @Override
    public void onEnable() {
        // Print out beautiful header
        printArt();

        moduleController = new ModuleController();
        moduleController.loadModules();
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

}
