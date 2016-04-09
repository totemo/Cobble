package io.totemo.cobble;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// ----------------------------------------------------------------------------
/**
 * ItemStack helper functions.
 */
public class Items {
    // ------------------------------------------------------------------------
    /**
     * Set the item name and lore lines of an item.
     *
     * Alternate colour codes on display names and lore will be translated.
     *
     * @param item the item.
     * @param name the name to give the item.
     * @param lore a list of lore lines to add in sequence.
     */
    public static void setNameAndLore(ItemStack item, String name, List<String> loreList) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        ArrayList<String> lores = new ArrayList<String>();
        for (String lore : loreList) {
            lores.add(ChatColor.translateAlternateColorCodes('&', lore));
        }
        meta.setLore(lores);
        item.setItemMeta(meta);
    }
} // class Items