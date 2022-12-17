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
                            PerWorldAll.getInstance().saveConfig();
                            PerWorldAll.getInstance().reloadConfig();
                            player.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "The plugin has been reloaded");
                        }

                        // Version subcommand
                        if (args[0].equalsIgnoreCase("version")) {
                            player.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "The plugin has been reloaded");
                        }

                        // PerWorldChat subcommands
                        if (args[0].equalsIgnoreCase("chat")) {

                            // PerWorldChat add subcommand
                            if (args[1].equalsIgnoreCase("set")) {
                                if (args.length >= 3) {
                                    List<String> oldWorldsList = PerWorldAll.getInstance().getConfig().getStringList("PerWorldChat.worlds");

                                    oldWorldsList.add(args[2]);

                                    PerWorldAll.getInstance().getConfig().set("PerWorldChat.worlds", oldWorldsList);
                                    PerWorldAll.getInstance().saveConfig();
                                    PerWorldAll.getInstance().reloadConfig();

                                    player.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "World " + args[2] + " has been added.");
                                } else {
                                    player.sendMessage(Messages.SYNTAX_ERROR);
                                }
                            }

                            // PerWorldChat remove subcommand
                            if (args[1].equalsIgnoreCase("remove")) {
                                List<String> oldWorldsList = PerWorldAll.getInstance().getConfig().getStringList("PerWorldChat.worlds");

                                oldWorldsList.remove(args[2]);

                                PerWorldAll.getInstance().getConfig().set("PerWorldChat.worlds", oldWorldsList);
                                PerWorldAll.getInstance().saveConfig();
                                PerWorldAll.getInstance().reloadConfig();

                                player.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "World " + args[2] + " has been removed.");
                            }
                        }

                        // PerWorldCommands subcommands
                        if (args[0].equalsIgnoreCase("commands")) {
                            if (args.length >= 2) {

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

                                            PerWorldAll.getInstance().getConfig().set("commands." + args[2], worldList);
                                            PerWorldAll.getInstance().saveConfig();
                                            PerWorldAll.getInstance().reloadConfig();

                                            player.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "The command " + args[2] + " has been added.");
                                        } else {
                                            player.sendMessage(Messages.SYNTAX_ERROR);
                                        }
                                    } else {
                                        player.sendMessage(Messages.SYNTAX_ERROR);
                                    }
                                }

                                // PerWorldCommands remove subcommand
                                if (args[1].equalsIgnoreCase("remove")) {
                                    if (args.length >= 3) {
                                        PerWorldAll.getInstance().getConfig().set("commands." + args[2], null);
                                        PerWorldAll.getInstance().saveConfig();
                                        PerWorldAll.getInstance().reloadConfig();

                                        player.sendMessage(ChatColor.DARK_GREEN + "[Successfully]: " + ChatColor.WHITE + "The command " + args[2] + " has been removed.");
                                    } else {
                                        player.sendMessage(Messages.SYNTAX_ERROR);
                                    }
                                }
                            } else {
                                player.sendMessage(Messages.SYNTAX_ERROR);
                            }
                        }

                        // PerWorldTabList subcommands

                        // PerWorldScoreboard subcommands
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
