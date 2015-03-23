package com.prnapps.javautils.reddit.domain.other;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/19/2015.
 */
public class Embed {
    @Expose
    protected String content;
    @Expose
    protected int width;
    @Expose
    protected int height;
    @Expose
    protected boolean scrolling;

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public boolean isScrolling() {
        return scrolling;
    }
    public void setScrolling(boolean scrolling) {
        this.scrolling = scrolling;
    }

}
