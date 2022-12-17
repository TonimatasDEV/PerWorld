package net.tonimatasdev.perworldtablist.event;

import net.tonimatasdev.perworldtablist.PerWorldAll;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PerWorldChatEvents implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (PerWorldAll.getInstance().getConfig().getStringList("PerWorldChat").contains(event.getPlayer().getWorld().getName())) {
            OfflinePlayer[] offlinePlayers = Bukkit.getServer().getOfflinePlayers();

            for (OfflinePlayer offlinePlayer : offlinePlayers) {
                if (offlinePlayer.isOnline() && !offlinePlayer.getPlayer().getWorld().getName().equals(event.getPlayer().getWorld().getName())) {
                    event.getRecipients().remove(offlinePlayer.getPlayer());
                }
            }
        } else {
            for (String worlds : PerWorldAll.getInstance().getConfig().getStringList("PerWorldChat")) {
                for (Player player : Bukkit.getWorld(worlds).getPlayers()) {
                    event.getRecipients().remove(player);
                }
            }
        }

    }
}
