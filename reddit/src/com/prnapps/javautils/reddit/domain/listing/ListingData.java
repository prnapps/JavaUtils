package com.prnapps.javautils.reddit.domain.listing;

import com.google.gson.annotations.Expose;
import com.prnapps.javautils.reddit.domain.thing.Thing;

import java.util.List;

/**
 * Created by jimbo on 3/20/2015.
 */
public class ListingData {
    @Expose
    private String before;
    @Expose
    private String after;
    @Expose
    protected int count;
    @Expose
    protected int limit;
    @Expose
    protected int show;
    @Expose
    protected String modhash;
    @Expose
    protected List<Thing> children;

    public String getBefore() {
        return before;
    }
    public void setBefore(String before) {
        this.before = before;
    }
    public String getAfter() {
        return after;
    }
    public void setAfter(String after) {
        this.after = after;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getShow() {
        return show;
    }
    public void setShow(int show) {
        this.show = show;
    }
    public String getModhash() {
        return modhash;
    }
    public void setModhash(String modhash) {
        this.modhash = modhash;
    }
    public List<Thing> getChildren() {
        return children;
    }
    public void setChildren(List<Thing> children) {
        this.children = children;
    }

}
