package me.eranspigel.superbow;


import me.eranspigel.superbow.commands.GiveCommand;
import me.eranspigel.superbow.listners.SuperBowListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SuperBow extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("givebow").setExecutor(new GiveCommand(this));

        getServer().getPluginManager().registerEvents(new SuperBowListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}