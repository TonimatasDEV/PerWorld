package net.tonimatasdev.perworldtablist.command;

import net.tonimatasdev.perworldtablist.PerWorldAll;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PerWorld implements CommandExecutor {
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("perworld")) {
            if (sender.hasPermission("perworld.admin")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;

                    if (args.length > 0) {
                        if (args[0].equalsIgnoreCase("chat")) {
                            if (args.length >= 1) {
                                if (args[1].equalsIgnoreCase("help")) {

                                }

                                if (args[1].equalsIgnoreCase("add")) {

                                }

                                if (args[1].equalsIgnoreCase("remove")) {

                                }
                            } else {
                                player.sendMessage("Syntax error");
                            }
                        }

                        if (args[0].equalsIgnoreCase("commands")) {

                        }
                    } else {
                        player.sendMessage("Syntax error");
                    }
                } else {
                    sender.sendMessage("No a player");
                }
            }
        }

        return true;
    }
}
