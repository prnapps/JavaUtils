package com.prnapps.javautils.reddit.domain.other;

/**
 * Created by jimbo on 4/2/2015.
 */
public enum Period {
    HOUR,
    DAY,
    WEEK,
    MONTH,
    YEAR,
    ALL;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
