package net.tonimatasdev.perworldall;

import net.tonimatasdev.perworldall.command.PerWorld;
import net.tonimatasdev.perworldall.event.PerWorldChatEvents;
import net.tonimatasdev.perworldall.util.PluginDescription;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class PerWorldAll extends JavaPlugin {
    private static PerWorldAll instance;

    @Override
    public void onEnable() {
        instance = this;

        PluginDescription.register();

        // Enable message
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + PluginDescription.getPrefix() + " has been enabled!");

        // Register commands
        getServer().getPluginManager().registerEvents(new PerWorldChatEvents(), this);
        getServer().getPluginManager().registerEvents(new PerWorldChatEvents(), this);
        getServer().getPluginManager().registerEvents(new PerWorldChatEvents(), this);
        getServer().getPluginManager().registerEvents(new PerWorldChatEvents(), this);

        // Register commands
        getServer().getPluginCommand("perworld").setExecutor(new PerWorld());

        // Register config
        saveDefaultConfig();
        reloadConfig();
    }

    @Override
    public void onDisable() {

    }

    public static PerWorldAll getInstance() {
        return instance;
    }
}
