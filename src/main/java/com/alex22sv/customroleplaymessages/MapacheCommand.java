package com.alex22sv.customroleplaymessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MapacheCommand implements CommandExecutor {
    private Util util;
    private String prefixMessage;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        util = new Util();
        prefixMessage = "<" + ChatColor.YELLOW + "Señor Mapache" + ChatColor.WHITE + ">";
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("customroleplaymessages.MapacheCommand")){
                if(args.length < 2){
                    player.sendMessage(util.missingArgsText(command.getName(), "player"));
                    return true;
                }
                if(Bukkit.getPlayer(args[0]) != null){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.sendMessage(prefixMessage + " " + util.fromArgsToString(args, 1));
                } else{
                    for(Player target : Bukkit.getOnlinePlayers()){
                        target.sendMessage(prefixMessage + " " + util.fromArgsToString(args, 0));
                    }
                }
            } else {
                util.missingPermissionsText(player);
            }
        } else {
            if(args.length < 2){
                System.out.println(util.missingArgsText(command.getName(), "console"));
                return true;
            }
            if(Bukkit.getOnlinePlayers().size() == 0){
                util.notOnlinePlayersFound();
                return true;
            }
            if(Bukkit.getPlayer(args[0]) != null){
                Player target = Bukkit.getPlayer(args[0]);
                target.sendMessage(prefixMessage + " " + util.fromArgsToString(args, 1));
            } else{
                for(Player target : Bukkit.getOnlinePlayers()){
                    target.sendMessage(prefixMessage + " " + util.fromArgsToString(args, 0));
                }
            }
        }
        return true;
    }
}
