package io.totemo.cobble;

import org.bukkit.Location;

// ----------------------------------------------------------------------------
/**
 * Functions for handling coordinates.
 */
public class Coords {
    // ------------------------------------------------------------------------
    /**
     * Format a Location as a string of the form (world, x, y, z), where x, y
     * and z are all integers.
     *
     * @param loc the Location.
     * @return the formatted Location.
     */
    public static String parensWorldInt(Location loc) {
        StringBuilder s = new StringBuilder();
        s.append('(').append(loc.getWorld().getName());
        s.append(", ").append(loc.getBlockX());
        s.append(", ").append(loc.getBlockY());
        s.append(", ").append(loc.getBlockZ());
        return s.append(')').toString();
    }

    // ------------------------------------------------------------------------
    /**
     * Format a Location as a string of the form (world, x, y, z), where x, y
     * and z are all doubles.
     *
     * @param loc the Location.
     * @return the formatted Location.
     */
    public static String parensWorldDouble(Location loc) {
        StringBuilder s = new StringBuilder();
        s.append('(').append(loc.getWorld().getName());
        s.append(", ").append(loc.getX());
        s.append(", ").append(loc.getY());
        s.append(", ").append(loc.getZ());
        return s.append(')').toString();
    }
} // class Coords