package com.prnapps.javautils.imgur.domain;

import com.google.gson.annotations.Expose;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by jimbo on 3/31/2015.
 */
public class Album {
    @Expose
    private String id;
    @Expose
    private String title;
    @Expose
    private String description;
    @Expose
    private Date datetime;
    @Expose
    private String cover;
    @Expose
    private int coverWidth;
    @Expose
    private int coverHeight;
    @Expose
    private String accountUrl;
    @Expose
    private int accountId;
    @Expose
    private String privacy;
    @Expose
    private String layout;
    @Expose
    private int views;
    @Expose
    private URL link;
    @Expose
    private boolean favorite;
    @Expose
    private boolean nsfw;
    @Expose
    private String section;
    @Expose
    private int order;
    @Expose
    private String deletehash;
    @Expose
    private int imagesCount;
    @Expose
    private List<Image> images;

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
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    public int getCoverWidth() {
        return coverWidth;
    }
    public void setCoverWidth(int coverWidth) {
        this.coverWidth = coverWidth;
    }
    public int getCoverHeight() {
        return coverHeight;
    }
    public void setCoverHeight(int coverHeight) {
        this.coverHeight = coverHeight;
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
    public String getPrivacy() {
        return privacy;
    }
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }
    public String getLayout() {
        return layout;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }
    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
    public URL getLink() {
        return link;
    }
    public void setLink(URL link) {
        this.link = link;
    }
    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    public boolean isNsfw() {
        return nsfw;
    }
    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }
    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public String getDeletehash() {
        return deletehash;
    }
    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }
    public int getImagesCount() {
        return imagesCount;
    }
    public void setImagesCount(int imagesCount) {
        this.imagesCount = imagesCount;
    }
    public List<Image> getImages() {
        return images;
    }
    public void setImages(List<Image> images) {
        this.images = images;
    }

}
