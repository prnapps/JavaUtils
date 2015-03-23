package com.prnapps.javautils.reddit.domain.other;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/19/2015.
 */
public class Media {
    @Expose
    protected String type;
    @Expose
    protected OEmbed oembed;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public OEmbed getOembed() {
        return oembed;
    }
    public void setOembed(OEmbed oembed) {
        this.oembed = oembed;
    }

}
