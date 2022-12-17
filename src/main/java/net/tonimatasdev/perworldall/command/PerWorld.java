package net.tonimatasdev.perworldall.command;

import net.tonimatasdev.perworldall.PerWorldAll;
import net.tonimatasdev.perworldall.util.Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PerWorld implements CommandExecutor {
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("perworld")) {
            if (sender.hasPermission("perworldall.admin")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;

                    if (args.length > 0) {

                        // Reload subcommand
                        if (args[0].equalsIgnoreCase("reload")) {
                            PerWorldAll.getInstance().reloadConfig();
                            PerWorldAll.getInstance().saveConfig();
                            player.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "The plugin has been reloaded");
                        }

                        // Version subcommand
                        if (args[0].equalsIgnoreCase("version")) {
                            // Fixme
                        }

                        // PerWorldChat subcommands
                        if (args[0].equalsIgnoreCase("chat")) {

                            // PerWorldChat help subcommand
                            if (args[1].equalsIgnoreCase("help")) {
                                // Fixme
                            }

                            // PerWorldChat add subcommand
                            if (args[1].equalsIgnoreCase("add")) {
                                // Fixme
                            }

                            // PerWorldChat remove subcommand
                            if (args[1].equalsIgnoreCase("remove")) {
                                // Fixme
                            }
                        }

                        // PerWorldCommands subcommands
                        if (args[0].equalsIgnoreCase("commands")) {
                            if (args.length >= 2) {

                                // PerWorldCommands remove subcommand
                                if (args[1].equalsIgnoreCase("remove")) {
                                    if (args.length >= 3) {
                                        PerWorldAll.getInstance().getConfig().set("commands." + args[2], null);
                                        PerWorldAll.getInstance().saveConfig();
                                        PerWorldAll.getInstance().reloadConfig();
                                        sender.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "The command " + args[2] + " has been removed.");
                                    } else {
                                        sender.sendMessage(Messages.SYNTAX_ERROR);
                                    }
                                }

                                // PerWorldCommands set subcommand
                                if (args[1].equalsIgnoreCase("set")) {
                                    if (args.length >= 3) {
                                        List<String> worldList = new ArrayList<>();

                                        int number = 3;

                                        if (args.length >= 4) {
                                            while (number <= 20) {
                                                if (args.length >= number + 1) {
                                                    worldList.add(args[number]);
                                                }

                                                number++;
                                            }

                                            PerWorldAll.getInstance().getConfig().set("commands." + args[2] + ".allowed-worlds", worldList);
                                            PerWorldAll.getInstance().saveConfig();
                                            PerWorldAll.getInstance().reloadConfig();
                                            sender.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "The command " + args [2] + " has been added.");
                                        } else {
                                            player.sendMessage(Messages.SYNTAX_ERROR);
                                        }
                                    } else {
                                        player.sendMessage(Messages.SYNTAX_ERROR);
                                    }
                                }

                                // PerWorldTabList subcommands

                                // PerWorldScoreboard subcommands
                            } else {
                                sender.sendMessage(Messages.SYNTAX_ERROR);
                            }
                        }
                    } else {
                        player.sendMessage(Messages.SYNTAX_ERROR);
                    }
                } else {
                    sender.sendMessage("No a player");
                }
            }
        }

        return true;
    }
}
