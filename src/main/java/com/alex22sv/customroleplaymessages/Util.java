package com.alex22sv.customroleplaymessages;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Util {
    // Plugin name
    public String pluginName = "[CustomRoleplayMessages]";

    // Messages
    public void missingPermissionsText(Player player){
        player.sendMessage(ChatColor.YELLOW + pluginName + ChatColor.RED + " No tienes permiso para ejecutar este comando.");
    }
    public void playerOnlyCommandText() {
        System.out.println(pluginName + " Este comando no puede ser ejecutado en la consola del servidor.");
    }
    public String missingArgsText(String commandName, String typeOfSender){
        if(typeOfSender == "player") {
            String message = ChatColor.YELLOW + pluginName + ChatColor.RED + " Argumentos incompletos. Ejecuta el comando /help " + commandName + " para más información.";
            return message;
        } else if(typeOfSender  == "console") {
            String message = pluginName + " Argumentos incompletos. Ejecuta el comando /help " + commandName + " para más información.";
            return message;
        } else {
            return null;
        }
    }
    public void notOnlinePlayersFound(){
        System.out.println(pluginName + " No hay jugadores en línea en el servidor");
    }

    // Util
    public String fromArgsToString(String[] args, int startNumber){
        // Convert an array of strings into a string
        // Use startNumber in case you want to ignore the first args.
        StringBuilder builderMsg = new StringBuilder();
        for (int i = startNumber; i < args.length; i++) {
            builderMsg.append(args[i]).append(" ");
        }
        return builderMsg.toString();
    }
    public String alternateColorFormat(String str){
        // Alternate the color format
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
