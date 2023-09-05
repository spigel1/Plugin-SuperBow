package me.eranspigel.superbow.listners;

import me.eranspigel.superbow.SuperBow;
import me.eranspigel.superbow.items.CreatingASuperBow;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class SuperBowListener implements Listener {

    private final SuperBow plugin;
    private final CreatingASuperBow bowUtils;

    public SuperBowListener(SuperBow plugin) {
        this.plugin = plugin;
        this.bowUtils = new CreatingASuperBow(plugin);
    }


    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {

        //check to see if it was shot by the teleport bow
        if (e.getEntity().getShooter() instanceof Player p) {

            ItemStack itemInMainHand = p.getInventory().getItemInMainHand();

            if (itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")))) {


                Location playerLocation = p.getLocation();
                Location location = e.getEntity().getLocation();

                p.teleport(location);
                // after teleporting summon 10 lighting bolt
                int numberOfLightning = plugin.getConfig().getInt("number-of-lightning");
                for (int i = 0; i < numberOfLightning; i++) {
                    p.getWorld().strikeLightning(playerLocation);
                }
                e.getEntity().remove();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("teleported-message")));
                p.playSound(p, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);

            }

        }


    }

}