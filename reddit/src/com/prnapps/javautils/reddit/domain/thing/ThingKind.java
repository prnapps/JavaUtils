package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jimbo on 3/19/2015.
 */
public enum ThingKind {
    @SerializedName("t1")
    COMMENT("t1"),
    @SerializedName("t2")
    ACCOUNT("t2"),
    @SerializedName("t3")
    LINK("t3"),
    @SerializedName("t4")
    MESSAGE("t4"),
    @SerializedName("t5")
    SUBREDDIT("t5"),
    @SerializedName("t6")
    AWARD("t6"),
    @SerializedName("t8")
    PROMOCAMPAIGN("t8");

    private String string;

    ThingKind(String string) {
        this.string = string;
    }

    public String toString() {
        return this.string;
    }

    public static ThingKind get(String string) {
        for(ThingKind kind : ThingKind.values()) {
            if(kind.toString().equals(string)) {
                return kind;
            }
        }
        return null;
    }
}
