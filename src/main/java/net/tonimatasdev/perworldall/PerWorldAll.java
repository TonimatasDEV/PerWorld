package net.tonimatasdev.perworldall;

import net.tonimatasdev.perworldall.command.PerWorld;
import net.tonimatasdev.perworldall.event.PerWorldChatEvents;
import net.tonimatasdev.perworldall.event.PerWorldCommandEvents;
import net.tonimatasdev.perworldall.event.PerWorldPlugins;
import net.tonimatasdev.perworldall.event.PerWorldTabListEvents;
import net.tonimatasdev.perworldall.tab.TabulatorCompleter;
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
        this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + PluginDescription.getPrefix() + " has been enabled!");

        // Register commands
        this.getServer().getPluginManager().registerEvents(new PerWorldChatEvents(), this);
        this.getServer().getPluginManager().registerEvents(new PerWorldCommandEvents(), this);
        this.getServer().getPluginManager().registerEvents(new PerWorldTabListEvents(), this);
        this.getServer().getPluginManager().registerEvents(new PerWorldPlugins(), this);

        // Register commands
        this.getServer().getPluginCommand("perworld").setExecutor(new PerWorld());
        this.getServer().getPluginCommand("perworld").setTabCompleter(new TabulatorCompleter());

        // Register config
        this.saveDefaultConfig();
        this.reloadConfig();
    }

    @Override
    public void onDisable() {

    }

    public static PerWorldAll getInstance() {
        return instance;
    }
}
