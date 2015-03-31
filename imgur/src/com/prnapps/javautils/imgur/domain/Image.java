package com.prnapps.javautils.imgur.domain;

import com.google.gson.annotations.Expose;

import java.net.URL;
import java.util.Date;

/**
 * Created by jimbo on 3/30/2015.
 */
public class Image {
    @Expose
    private String id;
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private Date datetime;
    @Expose
    private String type;
    @Expose
    private boolean animated;
    @Expose
    private int width;
    @Expose
    private int height;
    @Expose
    private long size;
    @Expose
    private long views;
    @Expose
    private long bandwidth;
    @Expose
    private String deletehash;
    @Expose
    private String name;
    @Expose
    private String section;
    @Expose
    private URL link;
    @Expose
    private URL gifv;
    @Expose
    private URL mp4;
    @Expose
    private URL webm;
    @Expose
    private boolean looping;
    @Expose
    private boolean favorite;
    @Expose
    private boolean nsfw;
    @Expose
    private String vote;
    @Expose
    private String accountUrl;
    @Expose
    private int accountId;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDatetime() {
        return datetime;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isAnimated() {
        return animated;
    }
    public void setAnimated(boolean animated) {
        this.animated = animated;
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
    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }
    public long getViews() {
        return views;
    }
    public void setViews(long views) {
        this.views = views;
    }
    public long getBandwidth() {
        return bandwidth;
    }
    public void setBandwidth(long bandwidth) {
        this.bandwidth = bandwidth;
    }
    public String getVote() {
        return vote;
    }
    public void setVote(String vote) {
        this.vote = vote;
    }
    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public String getAccountUrl() {
        return accountUrl;
    }
    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public URL getLink() {
        return link;
    }
    public void setLink(URL link) {
        this.link = link;
    }
    public String getDeletehash() {
        return deletehash;
    }
    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public URL getGifv() {
        return gifv;
    }
    public void setGifv(URL gifv) {
        this.gifv = gifv;
    }
    public URL getMp4() {
        return mp4;
    }
    public void setMp4(URL mp4) {
        this.mp4 = mp4;
    }
    public URL getWebm() {
        return webm;
    }
    public void setWebm(URL webm) {
        this.webm = webm;
    }
    public boolean isLooping() {
        return looping;
    }
    public void setLooping(boolean looping) {
        this.looping = looping;
    }
    public boolean isNsfw() {
        return nsfw;
    }
    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

}
