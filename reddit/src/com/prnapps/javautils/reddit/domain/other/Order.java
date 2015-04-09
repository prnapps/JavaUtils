package com.prnapps.javautils.reddit.domain.other;

/**
 * Created by jimbo on 4/2/2015.
 */
public enum Order {
    HOT,
    NEW,
    TOP,
    CONTROVERSIAL;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
