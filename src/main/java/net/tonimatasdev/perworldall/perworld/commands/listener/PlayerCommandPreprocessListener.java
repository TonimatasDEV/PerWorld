package net.tonimatasdev.perworldall.perworld.commands.listener;

import net.tonimatasdev.perworldall.PerWorldAll;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Objects;

public class PlayerCommandPreprocessListener implements Listener {
    @EventHandler
    public void PerWorldCommand(PlayerCommandPreprocessEvent event) {
        if (PerWorldAll.getInstance().getConfig().getBoolean("PerWorldCommands.enabled")) {
            String message = event.getMessage().split(" ")[0].replace("/", "");

            if (!event.getPlayer().hasPermission("perworldall.perwordcommands.bypass")) {
                if (!PerWorldAll.getInstance().getConfig().getStringList("PerWorldCommands.commands." + message.toLowerCase()).isEmpty()) {
                    if (PerWorldAll.getInstance().getConfig().getBoolean("PerWorldCommands.isWorldBlacklist")) {
                        if (PerWorldAll.getInstance().getConfig().getStringList("PerWorldCommands.commands." + message).contains(event.getPlayer().getWorld().getName().toLowerCase())) {
                            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldAll.getInstance().getConfig().getString("PerWorldCommands.globalBlockMessage"))));
                            event.setCancelled(true);
                        } else {
                            event.setCancelled(false);
                        }
                    } else {
                        if (!PerWorldAll.getInstance().getConfig().getStringList("PerWorldCommands.commands." + message).contains(event.getPlayer().getWorld().getName().toLowerCase())) {
                            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(PerWorldAll.getInstance().getConfig().getString("PerWorldCommands.globalBlockMessage"))));
                            event.setCancelled(true);
                        } else {
                            event.setCancelled(false);
                        }
                    }
                }
            }
        }
    }
}
