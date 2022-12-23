package net.tonimatasdev.perworldall.event;

import net.tonimatasdev.perworldall.PerWorldAll;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PerWorldTabListEvents implements Listener {
    @EventHandler
    public static void onPlayerChangeWorld(PlayerChangedWorldEvent event) {
        if (PerWorldAll.getInstance().getConfig().getBoolean("PerWorldTabList.enabled")) {
            for (Player player : event.getPlayer().getWorld().getPlayers()) {
                event.getPlayer().showPlayer(player);
                player.showPlayer(event.getPlayer());
            }

            for (Player player : event.getFrom().getPlayers()) {
                event.getPlayer().hidePlayer(player);
                player.hidePlayer(event.getPlayer());
            }
        }
    }

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (PerWorldAll.getInstance().getConfig().getBoolean("PerWorldTabList.enabled")) {
            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                if (p.getWorld() == player.getWorld()) {
                    p.showPlayer(player);
                    player.showPlayer(p);
                } else {
                    p.hidePlayer(player);
                    player.hidePlayer(p);
                }
            }
        }
    }
}
