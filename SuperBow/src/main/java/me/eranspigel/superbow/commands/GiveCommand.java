package me.eranspigel.superbow.commands;

import me.eranspigel.superbow.SuperBow;
import me.eranspigel.superbow.items.CreatingASuperBow;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCommand implements CommandExecutor {

    private final SuperBow plugin;
    private final CreatingASuperBow creatingASuperBow;

    public GiveCommand(SuperBow plugin) {
        this.plugin = plugin;
        this.creatingASuperBow = new CreatingASuperBow(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if(p.hasPermission("superbow.givebow")){

                if(args.length == 0){

                    ItemStack bow = creatingASuperBow.createSuperBow();
                    p.getInventory().addItem(bow);
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));

                    p.sendMessage(ChatColor.GREEN + "You have given yourself a teleport bow!!!");

                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if(target == null){
                        p.sendMessage(ChatColor.RED + "This player does not exist.");

                        return true;
                    }

                    ItemStack bow = creatingASuperBow.createSuperBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW, 1));

                    target.sendMessage(ChatColor.GREEN + "You have been given a teleport bow!!!");

                }

            }else{
                p.sendMessage("You do not have permission to run this command.");
            }

        }

        return true;
    }
}