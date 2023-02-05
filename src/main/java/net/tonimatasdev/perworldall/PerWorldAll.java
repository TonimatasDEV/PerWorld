package net.tonimatasdev.perworldall;

import net.tonimatasdev.perworldall.command.PerWorld;
import net.tonimatasdev.perworldall.perworld.chat.Chat;
import net.tonimatasdev.perworldall.perworld.commands.Commands;
import net.tonimatasdev.perworldall.perworld.tablist.TabList;
import net.tonimatasdev.perworldall.tab.TabulatorCompleter;
import net.tonimatasdev.perworldall.util.PluginDescription;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PerWorldAll extends JavaPlugin {
    private static PerWorldAll instance;

    @Override
    public void onEnable() {
        instance = this;

        PluginDescription.register();

        // Enable message
        this.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + PluginDescription.getPrefix() + " has been enabled!");

        // PerWorlds
        Chat.register();
        TabList.register();
        Commands.register();

        // Register commands
        Objects.requireNonNull(this.getServer().getPluginCommand("perworld")).setExecutor(new PerWorld());
        Objects.requireNonNull(this.getServer().getPluginCommand("perworld")).setTabCompleter(new TabulatorCompleter());

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
