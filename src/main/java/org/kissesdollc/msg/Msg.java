package org.kissesdollc.msg;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.kissesdollc.msg.command.MsgCommand;

public final class Msg extends JavaPlugin {

    CommandSender console = Bukkit.getConsoleSender();
    public String version = getDescription().getVersion();
    public String author = getDescription().getAuthors().toString();
    @Override
    public void onEnable() {
        getCommand("msg").setExecutor(new MsgCommand());

        console.sendMessage("----------------------------");
        console.sendMessage("§3MSG §7version §f"+version);
        console.sendMessage("§3Author §f"+author);
        console.sendMessage("----------------------------");

    }

    @Override
    public void onDisable() {
        console.sendMessage("§cGood Bye!");
    }
}
