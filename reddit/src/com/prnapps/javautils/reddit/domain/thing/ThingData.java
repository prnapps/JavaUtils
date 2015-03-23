package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/19/2015.
 */
public class ThingData {
    @Expose
    protected String id;

    // getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
