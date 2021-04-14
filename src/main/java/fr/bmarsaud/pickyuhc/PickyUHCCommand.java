package fr.bmarsaud.pickyuhc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class PickyUHCCommand implements CommandExecutor, TabCompleter {
    private static String PLUGIN_PREFIX = ChatColor.GREEN + "[" + ChatColor.YELLOW + "PickyUHC" + ChatColor.GREEN + "] ";
    private PickyUHC pickyUHC;

    public PickyUHCCommand(PickyUHC pickyUHC) {
        this.pickyUHC = pickyUHC;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(args.length == 1 && "reload".equals(args[0])) {
            pickyUHC.reloadConfig();
            pickyUHC.loadConfig();
            pickyUHC.updateAllPlayersRegen();
            commandSender.sendMessage(PLUGIN_PREFIX + "Config successfully reloaded!");
            return true;
        } else if(args.length == 2) {
            if("enable".equals(args[0])) {
                pickyUHC.setPlayerRegen(args[1], true);
                commandSender.sendMessage(PLUGIN_PREFIX + "Natural regeneration successfully enabled for player " + args[1]);
                return true;
            } else if("disable".equals(args[0])) {
                pickyUHC.setPlayerRegen(args[1], false);
                commandSender.sendMessage(PLUGIN_PREFIX + "Natural regeneration successfully disabled for player " + args[1]);
                return true;
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        if(args.length < 2) {
            return Arrays.asList("reload", "enable", "disable");
        } else if(args.length == 2 && !"reload".equalsIgnoreCase(args[0])) {
            return null;
        }
        return Arrays.asList();
    }
}
