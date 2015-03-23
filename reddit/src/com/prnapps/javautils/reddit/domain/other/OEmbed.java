package com.prnapps.javautils.reddit.domain.other;

import com.google.gson.annotations.Expose;

import java.net.URL;

/**
 * Created by jimbo on 3/19/2015.
 */
public class OEmbed {
    @Expose
    protected String title;
    @Expose
    protected String description;
    @Expose
    protected String type;
    @Expose
    protected String html;
    @Expose
    protected String authorName;
    @Expose
    protected URL authorUrl;
    @Expose
    protected String version;
    @Expose
    protected String providerName;
    @Expose
    protected URL providerUrl;
    @Expose
    protected int height;
    @Expose
    protected int width;
    @Expose
    protected URL thumbnailUrl;
    @Expose
    protected int thumbnailHeight;
    @Expose
    protected int thumbnailWidth;

    public int getThumbnailWidth() {
        return thumbnailWidth;
    }
    public void setThumbnailWidth(int thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }
    public int getThumbnailHeight() {
        return thumbnailHeight;
    }
    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }
    public URL getThumbnailUrl() {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(URL thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
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
    public URL getProviderUrl() {
        return providerUrl;
    }
    public void setProviderUrl(URL providerUrl) {
        this.providerUrl = providerUrl;
    }
    public String getProviderName() {
        return providerName;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public URL getAuthorUrl() {
        return authorUrl;
    }
    public void setAuthorUrl(URL authorUrl) {
        this.authorUrl = authorUrl;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getHtml() {
        return html;
    }
    public void setHtml(String html) {
        this.html = html;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
