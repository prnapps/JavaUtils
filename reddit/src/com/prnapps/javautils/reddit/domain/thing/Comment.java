package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.annotations.Expose;
import com.prnapps.javautils.reddit.domain.listing.Listing;
import com.prnapps.javautils.reddit.domain.other.FullName;

import java.util.Date;
import java.util.List;

/**
 * Created by jimbo on 3/19/2015.
 */
public class Comment extends ThingData {
    @Expose
    protected FullName name;
    @Expose
    protected String author;
    @Expose
    protected String body;
    @Expose
    protected String body_html;
    @Expose
    protected boolean edited;
    @Expose
    protected Date created;
    @Expose
    protected Date createdUtc;
    @Expose
    protected int score;
    @Expose
    protected int ups;
    @Expose
    protected int downs;
    @Expose
    protected boolean scoreHidden;
    @Expose
    protected int likes;
    @Expose
    protected int gilded;
    @Expose
    protected int controversiality;
    @Expose
    protected boolean saved;
    @Expose
    protected Listing replies;
    @Expose
    protected String bannedBy;
    @Expose
    protected List<String> userReports;
    @Expose
    protected List<String> modReports;
    @Expose
    protected int numReports;
    @Expose
    protected String reportReasons;
    @Expose
    protected FullName parentId;
    @Expose
    protected String approvedBy;
    @Expose
    protected String author_flair_css_class;
    @Expose
    protected String author_flair_text;
    @Expose
    protected String distinguished;
    @Expose
    protected FullName subredditId;
    @Expose
    protected String subreddit;
    @Expose
    protected FullName linkId;
    @Expose
    protected String linkTitle;
    @Expose
    protected String linkAuthor;
    @Expose
    protected String linkUrl;


    public FullName getName() {
        return name;
    }
    public void setName(FullName name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getBody_html() {
        return body_html;
    }
    public void setBody_html(String body_html) {
        this.body_html = body_html;
    }
    public boolean isEdited() {
        return edited;
    }
    public void setEdited(boolean edited) {
        this.edited = edited;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getUps() {
        return ups;
    }
    public void setUps(int ups) {
        this.ups = ups;
    }
    public int getDowns() {
        return downs;
    }
    public void setDowns(int downs) {
        this.downs = downs;
    }
    public boolean isScoreHidden() {
        return scoreHidden;
    }
    public void setScoreHidden(boolean scoreHidden) {
        this.scoreHidden = scoreHidden;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public Listing getReplies() {
        return replies;
    }
    public void setReplies(Listing replies) {
        this.replies = replies;
    }
    public int getGilded() {
        return gilded;
    }
    public void setGilded(int gilded) {
        this.gilded = gilded;
    }
    public int getControversiality() {
        return controversiality;
    }
    public void setControversiality(int controversiality) {
        this.controversiality = controversiality;
    }
    public boolean isSaved() {
        return saved;
    }
    public void setSaved(boolean saved) {
        this.saved = saved;
    }
    public String getBannedBy() {
        return bannedBy;
    }
    public void setBannedBy(String bannedBy) {
        this.bannedBy = bannedBy;
    }
    public List<String> getUserReports() {
        return userReports;
    }
    public void setUserReports(List<String> userReports) {
        this.userReports = userReports;
    }
    public List<String> getModReports() {
        return modReports;
    }
    public void setModReports(List<String> modReports) {
        this.modReports = modReports;
    }
    public int getNumReports() {
        return numReports;
    }
    public void setNumReports(int numReports) {
        this.numReports = numReports;
    }
    public String getReportReasons() {
        return reportReasons;
    }
    public void setReportReasons(String reportReasons) {
        this.reportReasons = reportReasons;
    }
    public FullName getParentId() {
        return parentId;
    }
    public void setParentId(FullName parentId) {
        this.parentId = parentId;
    }
    public String getApprovedBy() {
        return approvedBy;
    }
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
    public String getAuthor_flair_css_class() {
        return author_flair_css_class;
    }
    public void setAuthor_flair_css_class(String author_flair_css_class) {
        this.author_flair_css_class = author_flair_css_class;
    }
    public String getAuthor_flair_text() {
        return author_flair_text;
    }
    public void setAuthor_flair_text(String author_flair_text) {
        this.author_flair_text = author_flair_text;
    }
    public String getDistinguished() {
        return distinguished;
    }
    public void setDistinguished(String distinguished) {
        this.distinguished = distinguished;
    }
    public FullName getSubredditId() {
        return subredditId;
    }
    public void setSubredditId(FullName subredditId) {
        this.subredditId = subredditId;
    }
    public String getSubreddit() {
        return subreddit;
    }
    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }
    public FullName getLinkId() {
        return linkId;
    }
    public void setLinkId(FullName linkId) {
        this.linkId = linkId;
    }
    public String getLinkTitle() {
        return linkTitle;
    }
    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }
    public String getLinkAuthor() {
        return linkAuthor;
    }
    public void setLinkAuthor(String linkAuthor) {
        this.linkAuthor = linkAuthor;
    }
    public String getLinkUrl() {
        return linkUrl;
    }
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
    public Date getCreatedUtc() {
        return createdUtc;
    }
    public void setCreatedUtc(Date createdUtc) {
        this.createdUtc = createdUtc;
    }
}
