package io.totemo.cobble;

import java.util.List;
import java.util.Random;

// --------------------------------------------------------------------------
/**
 * Wrapper for java.util.Random to add additional methods.
 */
public class RNG {
    // ------------------------------------------------------------------------
    /**
     * Default constructor.
     *
     * Initialise with a random seed.
     */
    public RNG() {
        this(new Random());
    }

    // ------------------------------------------------------------------------
    /**
     * Constructor.
     *
     * @param random java.util.Random instance to use.
     */
    public RNG(Random random) {
        _random = random;
    }

    // ------------------------------------------------------------------------
    /**
     * Get the underlying java.util.Random instance.
     *
     * @return the underlying java.util.Random instance.
     */
    public Random getRandom() {
        return _random;
    }

    // ------------------------------------------------------------------------
    /**
     * Return a random integer in the range [0,bound-1].
     *
     * @param bound the exclusive upper bound.
     * @return a random integer in the range [0,bound-1].
     */
    public int nextInt(int bound) {
        return _random.nextInt(bound);
    }

    // ------------------------------------------------------------------------
    /**
     * Return a random integer in the range [min,max].
     *
     * @return a random integer in the range [min,max].
     */
    public int nextInt(int min, int max) {
        return min + _random.nextInt(max - min + 1);
    }

    // ------------------------------------------------------------------------
    /**
     * Forward nextDouble() to the java.util.Random instance.
     *
     * @return a random double in the range [0.0,1.0].
     */
    public double nextDouble() {
        return _random.nextDouble();
    }

    // ------------------------------------------------------------------------
    /**
     * Return a random double in the range [min,max].
     *
     * @return a random double in the range [min,max].
     */
    public double nextDouble(double min, double max) {
        return min + _random.nextDouble() * (max - min);
    }

    // ------------------------------------------------------------------------
    /**
     * Forward nextFloat() to the java.util.Random instance.
     *
     * @return a random float in the range [0.0,1.0].
     */
    public float nextFloat() {
        return _random.nextFloat();
    }

    // ------------------------------------------------------------------------
    /**
     * Return a random float in the range [min,max].
     *
     * @return a random float in the range [min,max].
     */
    public float nextFloat(float min, float max) {
        return min + _random.nextFloat() * (max - min);
    }

    // ------------------------------------------------------------------------
    /**
     * Generate a random action with the probability expressed as threshold.
     *
     * @param threshold the probability of an event happening, in the range
     *        [0.0.1.0].
     * @return true if the action should occur, or false if not.
     */
    public boolean probability(double threshold) {
        return _random.nextDouble() < threshold;
    }

    // ------------------------------------------------------------------------
    /**
     * Choose a random entry from an array.
     *
     * All options have equal probability of being selected.
     *
     * @param options the possible options.
     * @return one of the options.
     */
    public <T> T choose(T[] options) {
        return options[nextInt(options.length)];
    }

    // ------------------------------------------------------------------------
    /**
     * Choose a random entry from a a List<>.
     *
     * All options have equal probability of being selected.
     *
     * @param options the possible options.
     * @return one of the options.
     */
    public <T> T choose(List<T> options) {
        return options.get(nextInt(options.size()));
    }

    // ------------------------------------------------------------------------
    /**
     * Random number generator.
     */
    protected Random _random;
} // class RNG