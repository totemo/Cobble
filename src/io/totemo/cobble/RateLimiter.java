package io.totemo.cobble;

// ----------------------------------------------------------------------------
/**
 * Used to enforce a minimum time period in milliseconds between actions, e.g.
 * chat broadcasts.
 */
public class RateLimiter {
    // ------------------------------------------------------------------------
    /**
     * Constructor.
     *
     * @param minMillis minimum elapsed time in milliseconds since the last
     *        action before the next action can occur.
     */
    public RateLimiter(long minMillis) {
        _minMillis = minMillis;
    }

    // ------------------------------------------------------------------------
    /**
     * Return true if enough time has elapsed for an action to occur now.
     *
     * @return true if enough time has elapsed for an action to occur now.
     */
    public boolean canActNow() {
        long now = System.currentTimeMillis();
        if (now - _lastTime >= _minMillis) {
            _lastTime = now;
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------------
    /**
     * Minimum elapsed time in milliseconds since the last action before the
     * next action can occur.
     */
    protected long _minMillis;

    /**
     * The time at which action was last performed.
     */
    protected long _lastTime;
} // class RateLimiter