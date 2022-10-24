package com.alex22sv.customroleplaymessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AutorCommand implements CommandExecutor {
    private String prefixMessage;
    private Util util;
    private String author;
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
                author = args[0];
                prefixMessage = ChatColor.GREEN + author + ": ";
                if(Bukkit.getPlayer(args[1]) != null){
                    Player target = Bukkit.getPlayer(args[1]);
                    target.sendMessage(prefixMessage + ChatColor.YELLOW + util.fromArgsToString(args, 2));
                } else{
                    for(Player target : Bukkit.getOnlinePlayers()){
                        target.sendMessage(prefixMessage + ChatColor.YELLOW + util.fromArgsToString(args, 1));
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
            author = args[0];
            prefixMessage = ChatColor.BLUE + author + ": ";
            if(Bukkit.getPlayer(args[1]) != null){
                Player target = Bukkit.getPlayer(args[1]);
                target.sendMessage(prefixMessage + ChatColor.YELLOW + util.fromArgsToString(args, 2));
            } else{
                for(Player target : Bukkit.getOnlinePlayers()){
                    target.sendMessage(prefixMessage + ChatColor.YELLOW + util.fromArgsToString(args, 1));
                }
            }
        }
        return true;
    }
}
