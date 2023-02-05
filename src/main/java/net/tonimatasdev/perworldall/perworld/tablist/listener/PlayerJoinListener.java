package net.tonimatasdev.perworldall.perworld.tablist.listener;

import net.tonimatasdev.perworldall.PerWorldAll;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (PerWorldAll.getInstance().getConfig().getBoolean("PerWorldTabList.enabled")) {
            for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                if (onlinePlayer.getWorld() == player.getWorld()) {
                    onlinePlayer.showPlayer(player);
                    player.showPlayer(onlinePlayer);
                } else {
                    onlinePlayer.hidePlayer(player);
                    player.hidePlayer(onlinePlayer);
                }
            }
        }
    }
}
