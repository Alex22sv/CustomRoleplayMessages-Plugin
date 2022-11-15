package com.alex22sv.customroleplaymessages;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomRoleplayMessages extends JavaPlugin {
    private Util util;
    @Override
    public void onEnable() {
        // Plugin startup logic
        util = new Util();
        System.out.println(util.pluginName + " El plugin ha sido activado correctamente.");
        getCommand("admin").setExecutor(new AdminCommand());
        getCommand("autor").setExecutor(new AutorCommand());
        getCommand("dioses").setExecutor(new DiosesCommand());
        getCommand("servidor").setExecutor(new ServidorCommand());
        getCommand("eltopo").setExecutor(new ElTopoCommand());
        getCommand("elmapache").setExecutor(new ElMapacheCommand());
        getCommand("noticia").setExecutor(new NoticiaCommand());
        getCommand("kaspar").setExecutor(new KasparCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        util = new Util();
        System.out.println(util.pluginName + " El plugin ha sido desactivado correctamente.");
    }
}
