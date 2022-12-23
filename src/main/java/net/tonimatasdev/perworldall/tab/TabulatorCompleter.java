package net.tonimatasdev.perworldall.tab;

import net.tonimatasdev.perworldall.PerWorldAll;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabulatorCompleter  implements TabCompleter {

    private boolean hasPermission(CommandSender sender) {
        return sender.hasPermission("perworldall.admin");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("perworld")) {
            List<String> argList = new ArrayList<>();

            // Argument 1
            if (args.length == 1 && hasPermission(sender)) {
                argList.add("reload");
                argList.add("version");
                argList.add("commands");
                argList.add("chat");
                argList.add("tablist");
                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }

            // Argument 2
            if (args.length == 2 && args[0].equalsIgnoreCase("commands")) {
                argList.add("set");
                argList.add("remove");
                return argList;
            }

            if (args.length == 2 && args[0].equalsIgnoreCase("chat")) {
                argList.add("set");
                argList.add("remove");
                return argList;
            }

            if (args.length == 2 && args[0].equalsIgnoreCase("tablist")) {
                argList.add("enable");
                argList.add("disable");
                return argList;
            }

            // Argument 3
            if (args.length == 3 && args[0].equalsIgnoreCase("commands") && args[1].equalsIgnoreCase("set")) {
                argList.add("example");
                return argList;
            }

            if (args.length == 3 && args[0].equalsIgnoreCase("chat") && args[1].equalsIgnoreCase("set")) {
                for (World world : Bukkit.getWorlds()) {
                    argList.add(world.getName());
                }

                return argList;
            }

            if (args.length == 3 && args[0].equalsIgnoreCase("commands") && args[1].equalsIgnoreCase("remove")) {
                argList.addAll(PerWorldAll.getInstance().getConfig().getStringList("PerWorldCommands.commands"));
                return argList;
            }

            if (args.length == 3 && args[0].equalsIgnoreCase("chat") && args[1].equalsIgnoreCase("remove")) {
                argList.addAll(PerWorldAll.getInstance().getConfig().getStringList("PerWorldChat.worlds"));
                return argList;
            }

            // Argument 4
            int number = 4;

            while (number <= 20) {
                if (args.length == number && args[0].equalsIgnoreCase("set") && args[1].equalsIgnoreCase("cmd")) {
                    for (World world : Bukkit.getWorlds()) {
                        argList.add(world.getName());
                    }
                }

                number++;
            }

            return argList;
        }

        return null;
    }
}
