package net.tonimatasdev.perworldcore;

import net.tonimatasdev.perworldcore.api.Messages;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class PerWorldCore extends JavaPlugin {
    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();

        Messages.sendEnabledOrDisable(this, true);
    }

    @Override
    public void onDisable() {
        saveConfig();

        Messages.sendEnabledOrDisable(this, false);
    }

    public static Plugin getInstance() {
        return instance;
    }
}
