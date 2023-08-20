package net.tonimatasdev.tablist.listener;

import net.tonimatasdev.tablist.PerWorldTabList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerEvents implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerChangeWorld(PlayerChangedWorldEvent event) {
        Plugin plugin = PerWorldTabList.getInstance();

        for (Player player : event.getPlayer().getWorld().getPlayers()) {
            event.getPlayer().showPlayer(plugin, player);
            player.showPlayer(plugin, event.getPlayer());
        }

        for (Player player : event.getFrom().getPlayers()) {
            event.getPlayer().hidePlayer(plugin, player);
            player.hidePlayer(plugin, event.getPlayer());
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Plugin plugin = PerWorldTabList.getInstance();


        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            if (onlinePlayer.getWorld() == player.getWorld()) {
                onlinePlayer.showPlayer(plugin, player);
                player.showPlayer(plugin, onlinePlayer);
            } else {
                onlinePlayer.hidePlayer(plugin, player);
                player.hidePlayer(plugin, onlinePlayer);
            }
        }
    }
}
