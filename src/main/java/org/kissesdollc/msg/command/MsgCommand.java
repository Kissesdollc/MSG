package org.kissesdollc.msg.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("msg")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (args.length >= 2) {
                    String targetName = args[0];
                    Player target = Bukkit.getPlayer(targetName);

                    if (target != null && target.isOnline()) {
                        StringBuilder messageBuilder = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            messageBuilder.append(args[i]).append(" ");
                        }
                        String message = messageBuilder.toString().trim();
                        target.sendMessage(ChatColor.GRAY + "(From " + ChatColor.WHITE + player.getName() + ChatColor.GRAY + ") " + ChatColor.RESET + message);
                        sender.sendMessage(ChatColor.GRAY + "(To " + ChatColor.WHITE + target.getName() + ChatColor.GRAY + ") " + ChatColor.RESET + message);
                    } else {
                        sender.sendMessage(ChatColor.RED + "The specified player is not online.");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "usage: /msg <player> <message>");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "single player command.");
            }
            return true;
        }
        return false;
    }
}
