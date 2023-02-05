package net.tonimatasdev.perworldall.perworld.tablist.listener;

import net.tonimatasdev.perworldall.PerWorldAll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerChangeWorldListener implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.MONITOR)
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
}
