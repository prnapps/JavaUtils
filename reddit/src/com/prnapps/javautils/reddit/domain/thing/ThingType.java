package com.prnapps.javautils.reddit.domain.thing;

/**
 * Created by jimbo on 11/29/2014.
 */
public enum ThingType {
    COMMENT("t1"),
    ACCOUNT("t2"),
    LINK("t3"),
    MESSAGE("t4"),
    SUBREDDIT("t5"),
    AWARD("t6"),
    PROMOCAMPAIGN("t8");

    private String string;

    ThingType(String string) {
        this.string = string;
    }

    public String toString() {
        return this.string;
    }
}
