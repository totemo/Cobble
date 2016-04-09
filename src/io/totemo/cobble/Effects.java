package io.totemo.cobble;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

// ----------------------------------------------------------------------------
/**
 * Special effect helper functions.
 *
 * For the firework effect functions, the intended use is something like:
 *
 * <pre>
 * FireworkEffect.Type[] FIREWORK_TYPES[] = { ... };
 * Location location;
 * 
 * FireworkEffect.Builder builder = FireworkEffect.builder();
 * Effects.randomType(builder, FIREWORK_TYPES, 0.3, 0.3);
 * Effects.randomPrimaries(builder, 1, 4, Color.fromRGB(0, 0, 0), Color.fromRGB(255, 255, 255));
 * Effects.randomFades(builder, 1, 2, Color.fromRGB(0, 0, 0), Color.fromRGB(255, 255, 255));
 * Effects.spawnFirework(location, builder.build(), _random.nextInt(0, 2));
 * </pre>
 */
public class Effects {
    // ------------------------------------------------------------------------
    /**
     * Spawn a firework at the specified location.
     *
     * @param origin the location where the firework is spawned.
     */
    public static FireworkEffect.Builder randomType(FireworkEffect.Builder builder,
                                                    FireworkEffect.Type[] types, double flickerChance,
                                                    double trailChance) {
        builder.with(_random.choose(types));
        if (_random.nextDouble() < flickerChance) {
            builder.withFlicker();
        }
        if (_random.nextDouble() < trailChance) {
            builder.withTrail();
        }
        return builder;
    }

    // ------------------------------------------------------------------------
    /**
     * Choose a random colour.
     *
     * @param minColour the minimum colour component values (RGB).
     * @param maxColour the maximum colour component values (RGB).
     * @return the colour.
     */
    public static Color randomColour(Color minColour, Color maxColour) {
        return Color.fromRGB(_random.nextInt(minColour.getRed(), maxColour.getRed()),
                             _random.nextInt(minColour.getGreen(), maxColour.getGreen()),
                             _random.nextInt(minColour.getBlue(), maxColour.getBlue()));
    }

    // ------------------------------------------------------------------------
    /**
     * Add a random number of random primary colours to a firework effect.
     *
     * @param builder the firework builder.
     * @param min the minimum number of colours to add.
     * @param max the maximum number of colours to add.
     * @param minColour the minimum colour component values (RGB).
     * @param maxColour the maximum colour component values (RGB).
     */
    public static FireworkEffect.Builder randomPrimaries(FireworkEffect.Builder builder,
                                                         int min, int max, Color minColour, Color maxColour) {
        for (int i = 0; i < _random.nextInt(min, max); ++i) {
            builder.withColor(randomColour(minColour, maxColour));
        }
        return builder;
    }

    // ------------------------------------------------------------------------
    /**
     * Add a random number of random fade colours to a firework effect.
     *
     * @param builder the firework builder.
     * @param min the minimum number of colours to add.
     * @param max the maximum number of colours to add.
     * @param minColour the minimum colour component values (RGB).
     * @param maxColour the maximum colour component values (RGB).
     */
    public static FireworkEffect.Builder randomFades(FireworkEffect.Builder builder,
                                                     int min, int max, Color minColour, Color maxColour) {
        for (int i = 0; i < _random.nextInt(min, max); ++i) {
            builder.withFade(randomColour(minColour, maxColour));
        }
        return builder;
    }

    // ------------------------------------------------------------------------
    /**
     * Spawn a firework at the specified Location, with the specified effect and
     * power.
     *
     * @param power the firework power from 0 to 128; each unit adds about 0.5
     *        seconds of flight time.
     */
    public static void spawnFirework(Location origin, FireworkEffect effect, int power) {
        World world = origin.getWorld();
        Firework firework = (Firework) world.spawnEntity(origin, EntityType.FIREWORK);
        if (firework != null) {
            FireworkMeta meta = firework.getFireworkMeta();
            meta.setPower(power);
            meta.addEffect(effect);
            firework.setFireworkMeta(meta);
        }
    }

    // ------------------------------------------------------------------------
    /**
     * Random number generator.
     */
    protected static RNG _random = new RNG();
} // class Effects