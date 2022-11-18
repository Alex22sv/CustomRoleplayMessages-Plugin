package com.alex22sv.customroleplaymessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AutorCommand implements CommandExecutor {
    private Util util;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        util = new Util();
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("customroleplaymessages.AutorCommand")){
                if(args.length < 3){
                    player.sendMessage(util.missingArgsText(command.getName(), "player"));
                    return true;
                }
                if(Bukkit.getPlayer(args[1]) != null){
                    Player target = Bukkit.getPlayer(args[1]);
                    target.sendMessage(util.selectAuthorStyle(args[0]) + util.fromArgsToString(args, 2));
                } else{
                    for(Player target : Bukkit.getOnlinePlayers()){
                        target.sendMessage(util.selectAuthorStyle(args[0]) + util.fromArgsToString(args, 1));
                    }
                }
            } else {
                util.missingPermissionsText(player);
                return true;
            }
        } else {
            if(args.length < 3){
                System.out.println(util.missingArgsText(command.getName(), "console"));
                return true;
            }
            if(Bukkit.getOnlinePlayers().size() == 0){
                util.notOnlinePlayersFound();
                return true;
            }
            if(Bukkit.getPlayer(args[1]) != null){
                Player target = Bukkit.getPlayer(args[1]);
                target.sendMessage(util.selectAuthorStyle(args[0]) + util.fromArgsToString(args, 2));
            } else{
                for(Player target : Bukkit.getOnlinePlayers()){
                    target.sendMessage(util.selectAuthorStyle(args[0]) + util.fromArgsToString(args, 1));
                }
            }
        }
        return true;
    }
}
