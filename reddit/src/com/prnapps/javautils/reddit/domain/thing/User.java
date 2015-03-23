package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by jimbo on 3/19/2015.
 */
public class User extends ThingData {
    @Expose
    protected String name;
    @Expose
    protected boolean isFriend;
    @Expose
    protected Date created;
    @Expose
    protected Date createdUtc;
    @Expose
    protected int linkKarma;
    @Expose
    protected int commentKarma;
    @Expose
    protected boolean isGold;
    @Expose
    protected boolean isMod;
    @Expose
    protected boolean hasVerifiedEmail;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isFriend() {
        return isFriend;
    }
    public void setFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getCreatedUtc() {
        return createdUtc;
    }
    public void setCreatedUtc(Date createdUtc) {
        this.createdUtc = createdUtc;
    }
    public int getLinkKarma() {
        return linkKarma;
    }
    public void setLinkKarma(int linkKarma) {
        this.linkKarma = linkKarma;
    }
    public int getCommentKarma() {
        return commentKarma;
    }
    public void setCommentKarma(int commentKarma) {
        this.commentKarma = commentKarma;
    }
    public boolean isGold() {
        return isGold;
    }
    public void setGold(boolean isGold) {
        this.isGold = isGold;
    }
    public boolean isMod() {
        return isMod;
    }
    public void setMod(boolean isMod) {
        this.isMod = isMod;
    }
    public boolean isHasVerifiedEmail() {
        return hasVerifiedEmail;
    }
    public void setHasVerifiedEmail(boolean hasVerifiedEmail) {
        this.hasVerifiedEmail = hasVerifiedEmail;
    }

}
