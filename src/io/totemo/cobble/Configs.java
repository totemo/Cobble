package io.totemo.cobble;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

// ----------------------------------------------------------------------------
/**
 * Configuration helper functions.
 */
public class Configs {
    // ------------------------------------------------------------------------
    /**
     * Return a World, named in a ConfigurationSection at a specified path.
     *
     * If the specified World doesn't exist, try a default World name instead.
     *
     * @param section the ConfigurationSection.
     * @param path the path to a String value in the section that will be used
     *        as the World name.
     * @param defaultWorldName the default fallback World name, or null if
     *        unspecified.
     */
    public World getWorld(ConfigurationSection section, String path, String defaultWorldName) {
        World world = Bukkit.getWorld(section.getString(path));
        if (world == null && defaultWorldName != null) {
            world = Bukkit.getWorld(defaultWorldName);
        }
        return world;
    }

    // ------------------------------------------------------------------------
    /**
     * Load a shaped recipe from the specified configuration section.
     *
     * An example of the expected configuration file contents is as follows:
     *
     * <pre>
     * recipe:
     *   ingredients:
     *     e: EGG
     *     s: SULPHUR
     *     n: GOLD_NUGGET
     *   shape:
     *   - "sns"
     *   - "nen"
     *   - "sns"
     * </pre>
     *
     * @param section the section to load from.
     * @return a shaped recipe.
     */
    public ShapedRecipe loadShapedRecipe(ConfigurationSection section, ItemStack result) {
        ShapedRecipe recipe = new ShapedRecipe(result);
        recipe.shape(section.getStringList("shape").toArray(new String[3]));

        ConfigurationSection ingredients = section.getConfigurationSection("ingredients");
        for (String letter : ingredients.getKeys(false)) {
            Material ingredient = Material.valueOf(ingredients.getString(letter));
            recipe.setIngredient(letter.charAt(0), ingredient);
        }
        return recipe;
    }

    // ------------------------------------------------------------------------
    /**
     * Load an enchantment from a specified configuration section and apply it
     * to ItemMeta.
     *
     * @param section the section to load the enchantment from.
     * @param meta the ItemMeta into which the enchantment will be added.
     */
    public void loadEnchantment(ConfigurationSection section, ItemMeta meta) {
        Enchantment type = Enchantment.getByName(section.getString("type"));
        int level = section.getInt("level", 1);
        meta.addEnchant(type, level, true);
    }

    // ------------------------------------------------------------------------
    /**
     * Load a string list from the configuration under the specified path,
     * translate alternate colour codes and return a list of the translated
     * strings.
     *
     * @param path the configuration section path.
     * @return a list of lore strings.
     */
    public List<String> loadStrings(ConfigurationSection section, String path) {
        ArrayList<String> loreList = new ArrayList<String>();
        for (String lore : section.getStringList(path)) {
            loreList.add(ChatColor.translateAlternateColorCodes('&', lore));
        }
        return loreList;
    }
} // class Configs