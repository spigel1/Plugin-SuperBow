package me.eranspigel.superbow.items;

import me.eranspigel.superbow.SuperBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

//Create and provide teleport bows
public class CreatingASuperBow {

    private final SuperBow plugin;

    public CreatingASuperBow(SuperBow plugin) {
        this.plugin = plugin;
    }

    public ItemStack createSuperBow(){

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-description")));
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bow.setItemMeta(bowMeta);

        return bow;
    }

}