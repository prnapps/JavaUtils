package com.prnapps.javautils.reddit.domain.thing;

import com.google.gson.annotations.Expose;
import com.prnapps.javautils.reddit.domain.other.Embed;
import com.prnapps.javautils.reddit.domain.other.FullName;
import com.prnapps.javautils.reddit.domain.other.Media;

import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * Created by jimbo on 3/19/2015.
 */
public class Link extends ThingData {
    @Expose
    protected FullName name;
    @Expose
    protected String title;
    @Expose
    protected URL url;
    @Expose
    protected URL thumbnail;
    @Expose
    protected String selftext;
    @Expose
    protected String selftextHtml;
    @Expose
    protected Media media;
    @Expose
    protected Embed mediaEmbed;
    @Expose
    protected String secureMedia;
    @Expose
    protected Embed secureMediaEmbed;
    @Expose
    protected String domain;
    @Expose
    protected String permalink;
    @Expose
    protected Date created;
    @Expose
    protected Date createdUtc;
    @Expose
    protected int numComments;
    @Expose
    protected int score;
    @Expose
    protected int ups;
    @Expose
    protected int downs;
    @Expose
    protected int likes;
    @Expose
    protected int gilded;
    @Expose
    protected boolean saved;
    @Expose
    protected boolean clicked;
    @Expose
    protected boolean over18;
    @Expose
    protected boolean hidden;
    @Expose
    protected boolean isSelf;
    @Expose
    protected boolean stickied;
    @Expose
    protected String linkFlairText;
    @Expose
    protected String linkFlairCssClass;
    @Expose
    protected boolean visited;
    @Expose
    protected boolean distinguished;
    @Expose
    protected String bannedBy;
    @Expose
    protected String approvedBy;
    @Expose
    protected List<String> modReports;
    @Expose
    protected List<String> userReports;
    @Expose
    protected String reportReasons;
    @Expose
    protected int numReports;
    @Expose
    protected FullName subredditId;
    @Expose
    protected String subreddit;
    @Expose
    protected String author;
    @Expose
    protected String authorFlairText;
    @Expose
    protected String authorFlairCssClass;

    // getters and setters
    public FullName getName() {
        return name;
    }
    public void setName(FullName name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public URL getUrl() {
        return url;
    }
    public void setUrl(URL url) {
        this.url = url;
    }
    public URL getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(URL thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getSelftext() {
        return selftext;
    }
    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }
    public String getSelftextHtml() {
        return selftextHtml;
    }
    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }
    public Media getMedia() {
        return media;
    }
    public void setMedia(Media media) {
        this.media = media;
    }
    public Embed getMediaEmbed() {
        return mediaEmbed;
    }
    public void setMediaEmbed(Embed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }
    public String getSecureMedia() {
        return secureMedia;
    }
    public void setSecureMedia(String secureMedia) {
        this.secureMedia = secureMedia;
    }
    public Embed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }
    public void setSecureMediaEmbed(Embed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public String getPermalink() {
        return permalink;
    }
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public int getNumComments() {
        return numComments;
    }
    public void setNumComments(int numComments) {
        this.numComments = numComments;
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
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public int getGilded() {
        return gilded;
    }
    public void setGilded(int gilded) {
        this.gilded = gilded;
    }
    public boolean isSaved() {
        return saved;
    }
    public void setSaved(boolean saved) {
        this.saved = saved;
    }
    public boolean isClicked() {
        return clicked;
    }
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    public boolean isOver18() {
        return over18;
    }
    public void setOver18(boolean over18) {
        this.over18 = over18;
    }
    public boolean isHidden() {
        return hidden;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public boolean isSelf() {
        return isSelf;
    }
    public void setSelf(boolean isSelf) {
        this.isSelf = isSelf;
    }
    public boolean isStickied() {
        return stickied;
    }
    public void setStickied(boolean stickied) {
        this.stickied = stickied;
    }
    public String getLinkFlairText() {
        return linkFlairText;
    }
    public void setLinkFlairText(String linkFlairText) {
        this.linkFlairText = linkFlairText;
    }
    public String getLinkFlairCssClass() {
        return linkFlairCssClass;
    }
    public void setLinkFlairCssClass(String linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public boolean isDistinguished() {
        return distinguished;
    }
    public void setDistinguished(boolean distinguished) {
        this.distinguished = distinguished;
    }
    public String getBannedBy() {
        return bannedBy;
    }
    public void setBannedBy(String bannedBy) {
        this.bannedBy = bannedBy;
    }
    public String getApprovedBy() {
        return approvedBy;
    }
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
    public List<String> getModReports() {
        return modReports;
    }
    public void setModReports(List<String> modReports) {
        this.modReports = modReports;
    }
    public List<String> getUserReports() {
        return userReports;
    }
    public void setUserReports(List<String> userReports) {
        this.userReports = userReports;
    }
    public String getReportReasons() {
        return reportReasons;
    }
    public void setReportReasons(String reportReasons) {
        this.reportReasons = reportReasons;
    }
    public int getNumReports() {
        return numReports;
    }
    public void setNumReports(int numReports) {
        this.numReports = numReports;
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
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthorFlairText() {
        return authorFlairText;
    }
    public void setAuthorFlairText(String authorFlairText) {
        this.authorFlairText = authorFlairText;
    }
    public String getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }
    public void setAuthorFlairCssClass(String authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

}
