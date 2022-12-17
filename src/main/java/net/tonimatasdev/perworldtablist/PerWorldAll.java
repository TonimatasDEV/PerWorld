package net.tonimatasdev.perworldtablist;

import net.tonimatasdev.perworldtablist.command.PerWorld;
import net.tonimatasdev.perworldtablist.event.PerWorldChatEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class PerWorldAll extends JavaPlugin {
    private static PerWorldAll instance;

    @Override
    public void onEnable() {
        instance = this;

        this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "PerWorldChat was enabled!");
        this.getServer().getPluginManager().registerEvents(new PerWorldChatEvents(), this);
        this.getServer().getPluginCommand("pwc").setExecutor(new PerWorld());
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
