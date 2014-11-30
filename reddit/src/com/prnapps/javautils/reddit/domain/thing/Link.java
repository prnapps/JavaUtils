package com.prnapps.javautils.reddit.domain.thing;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.prnapps.javautils.reddit.domain.Flair;
import com.prnapps.javautils.utils.AbstractJsonDeserializer;

public class Link extends AbstractThing {
	private String title;
	private Flair linkFlair;
	private String url;
	private String permalink;
	private String domain;
	private String selfText;
	private Media media;
	private User author;
	private Flair authorFlair;
	private Subreddit subreddit;
	private Date created;
	private int score;
	private int ups;
	private int downs;
	private int gilded;
	private int comments;
	private int reports;
	private boolean self;
	private boolean saved;
	private boolean edited;
	private boolean over18;
	private boolean stickied;
	private boolean hidden;
	private boolean visited;
	private boolean clicked;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Flair getLinkFlair() {
		return linkFlair;
	}
	public void setLinkFlair(Flair linkFlair) {
		this.linkFlair = linkFlair;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPermalink() {
		return permalink;
	}
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSelfText() {
		return selfText;
	}
	public void setSelfText(String selfText) {
		this.selfText = selfText;
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Flair getAuthorFlair() {
		return authorFlair;
	}
	public void setAuthorFlair(Flair authorFlair) {
		this.authorFlair = authorFlair;
	}
	public Subreddit getSubreddit() {
		return subreddit;
	}
	public void setSubreddit(Subreddit subreddit) {
		this.subreddit = subreddit;
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
	public int getGilded() {
		return gilded;
	}
	public void setGilded(int gilded) {
		this.gilded = gilded;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public int getReports() {
		return reports;
	}
	public void setReports(int reports) {
		this.reports = reports;
	}
	public boolean isSelf() {
		return self;
	}
	public void setSelf(boolean self) {
		this.self = self;
	}
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public boolean isEdited() {
		return edited;
	}
	public void setEdited(boolean edited) {
		this.edited = edited;
	}
	public boolean isOver18() {
		return over18;
	}
	public void setOver18(boolean over18) {
		this.over18 = over18;
	}
	public boolean isStickied() {
		return stickied;
	}
	public void setStickied(boolean stickied) {
		this.stickied = stickied;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isClicked() {
		return clicked;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	public static class LinkDeserializer extends AbstractJsonDeserializer<Link> {
		@Override
		public Link deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
			Link link = new Link();
			JsonObject object = element.getAsJsonObject();
			if(object != null) {
				link.setKind(getString(object.get("kind")));
				JsonObject data = object.get("data").getAsJsonObject();
				if(data != null) {
					link.setId(getString(data.get("id")));
					link.setTitle(getString(data.get("title")));
					Flair flair = new Flair();
					flair.setText(getString(data.get("link_flair_text")));
					flair.setCssClass(getString(data.get("link_flair_css_class")));
					link.setLinkFlair(flair);
					link.setUrl(getString(data.get("url")));
					link.setPermalink(getString(data.get("permalink")));
					link.setDomain(getString(data.get("domain")));
					link.setSelfText(getString(data.get("selftext")));
					if(getJsonObject(data.get("media")) != null) {
						link.setMedia((Media) context.deserialize(data.get("media"), Media.class));
					}
					User author = new User();
					author.setName(getString(data.get("author")));
					link.setAuthor(author);
					Flair authorFlair = new Flair();
					authorFlair.setText(getString(data.get("author_flair_text")));
					authorFlair.setCssClass(getString(data.get("author_flair_css_class")));
					link.setAuthorFlair(authorFlair);
					Subreddit subreddit = new Subreddit();
					subreddit.setFullname(getString(data.get("subreddit_id")));
					subreddit.setName(getString(data.get("subreddit")));
					link.setSubreddit(subreddit);
					link.setCreated(new Date(getLong(data.get("created_utc")) * 1000));
					link.setScore(getInt(data.get("score")));
					link.setUps(getInt(data.get("ups")));
					link.setDowns(getInt(data.get("downs")));
					link.setGilded(getInt(data.get("gilded")));
					link.setComments(getInt(data.get("num_comments")));
					link.setReports(getInt(data.get("num_reports")));
					link.setSelf(getBoolean(data.get("is_self")));
					link.setSaved(getBoolean(data.get("saved")));
					link.setEdited(getBoolean(data.get("edited")));
					link.setOver18(getBoolean(data.get("over_18")));
					link.setStickied(getBoolean(data.get("stickied")));
					link.setHidden(getBoolean(data.get("hidden")));
					link.setVisited(getBoolean(data.get("visited")));
					link.setClicked(getBoolean(data.get("clicked")));
				}
			}
			return link;
		}
	}
}
