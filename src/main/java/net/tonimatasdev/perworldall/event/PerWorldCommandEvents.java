package net.tonimatasdev.perworldall.event;

import net.tonimatasdev.perworldall.PerWorldAll;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PerWorldCommandEvents implements Listener {

    @EventHandler
    public void PerWorldCommand(PlayerCommandPreprocessEvent event) {
        if (PerWorldAll.getInstance().getConfig().getBoolean("PerWorldCommands.enabled")) {
            String message = event.getMessage().split(" ")[0].replace("/", "");

            if (!event.getPlayer().hasPermission("perworldall.perwordcommands.bypass")) {
                if (PerWorldAll.getInstance().getConfig().getConfigurationSection("commands." + message.toLowerCase()) != null) {
                    if (PerWorldAll.getInstance().getConfig().getBoolean("PerWorldCommands.isWorldBlacklist")) {
                        if (PerWorldAll.getInstance().getConfig().getStringList("PerWorldCommands.commands." + message).contains(event.getPlayer().getWorld().getName().toLowerCase())) {
                            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', PerWorldAll.getInstance().getConfig().getString("PerWorldCommands.globalBlockMessage")));
                            event.setCancelled(true);
                        } else {
                            event.setCancelled(false);
                        }
                    } else {
                        if (!PerWorldAll.getInstance().getConfig().getStringList("PerWorldCommands.commands." + message).contains(event.getPlayer().getWorld().getName().toLowerCase())) {
                            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', PerWorldAll.getInstance().getConfig().getString("PerWorldCommands.globalBlockMessage")));
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
