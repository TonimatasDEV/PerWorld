package net.tonimatasdev.perworldall.perworld.chat.listener;

import net.tonimatasdev.perworldall.PerWorldAll;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Objects;

public class AsyncPlayerChatListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (PerWorldAll.getInstance().getConfig().getBoolean("PerWorldChat.enabled")) {
            if (PerWorldAll.getInstance().getConfig().getStringList("PerWorldChat.worlds").contains(event.getPlayer().getWorld().getName())) {
                OfflinePlayer[] offlinePlayers = Bukkit.getServer().getOfflinePlayers();

                for (OfflinePlayer offlinePlayer : offlinePlayers) {
                    if (offlinePlayer.isOnline() && !Objects.requireNonNull(offlinePlayer.getPlayer()).getWorld().getName().equals(event.getPlayer().getWorld().getName())) {
                        event.getRecipients().remove(offlinePlayer.getPlayer());
                    }
                }
            } else {
                for (String worldName : PerWorldAll.getInstance().getConfig().getStringList("PerWorldChat.worlds")) {
                    World world = event.getPlayer().getServer().getWorld(worldName);

                    if (world != null) {
                        for (Player player : world.getPlayers()) {
                            event.getRecipients().remove(player);
                        }
                    }
                }
            }
        }
    }
}
