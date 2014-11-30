package com.prnapps.javautils.reddit.domain.thing;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.prnapps.javautils.reddit.domain.Flair;
import com.prnapps.javautils.utils.AbstractJsonDeserializer;

public class Comment extends AbstractThing {
	private Link link;
	private Subreddit subreddit;
	private User author;
	private Flair authorFlair;
	private Date created;
	private String body;
	private String bodyHtml;
	private int score;
	private int ups;
	private int downs;
	private int gilded;
	private int contoversiality;
	private int likes;
	private int replies;
	private int reports;
	private boolean saved;
	private boolean edited;
	private boolean scoreHidden;
	
	public Link getLink() {
		return link;
	}
	public void setLink(Link link) {
		this.link = link;
	}
	public Subreddit getSubreddit() {
		return subreddit;
	}
	public void setSubreddit(Subreddit subreddit) {
		this.subreddit = subreddit;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getBodyHtml() {
		return bodyHtml;
	}
	public void setBodyHtml(String bodyHtml) {
		this.bodyHtml = bodyHtml;
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
	public int getContoversiality() {
		return contoversiality;
	}
	public void setContoversiality(int contoversiality) {
		this.contoversiality = contoversiality;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getReplies() {
		return replies;
	}
	public void setReplies(int replies) {
		this.replies = replies;
	}
	public int getReports() {
		return reports;
	}
	public void setReports(int reports) {
		this.reports = reports;
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
	public boolean isScoreHidden() {
		return scoreHidden;
	}
	public void setScoreHidden(boolean scoreHidden) {
		this.scoreHidden = scoreHidden;
	}
	
	public static class CommentDeserializer extends AbstractJsonDeserializer<Comment> {
		@Override
		public Comment deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
			Comment comment = new Comment();
			JsonObject object = getJsonObject(element);
			if(object != null) {
				comment.setKind(getString(object.get("kind")));
				JsonObject data = getJsonObject(object.get("data"));
				if(data != null) {
					comment.setId(getString(data.get("id")));
					Link link = new Link();
					link.setFullname(getString(data.get("link_id")));
					link.setTitle(getString(data.get("link_title")));
					link.setUrl(getString(data.get("link_url")));
					User linkAuthor = new User();
					linkAuthor.setName(getString(data.get("link_author")));
					link.setAuthor(linkAuthor);
					comment.setLink(link);
					Subreddit subreddit = new Subreddit();
					subreddit.setFullname(getString(data.get("subreddit_id")));
					subreddit.setName(getString(data.get("subreddit")));
					comment.setSubreddit(subreddit);
					User author = new User();
					author.setName(getString(data.get("author")));
					comment.setAuthor(author);
					Flair authorFlair = new Flair();
					authorFlair.setText(getString(data.get("author_flair_text")));
					authorFlair.setCssClass(getString(data.get("author_flair_css_class")));
					comment.setAuthorFlair(authorFlair);
					comment.setCreated(new Date(getLong(data.get("created_utc")) * 1000));
					comment.setBody(getString(data.get("body")));
					comment.setBodyHtml(getString(data.get("body_html")));
					comment.setScore(getInt(data.get("score")));
					comment.setUps(getInt(data.get("ups")));
					comment.setDowns(getInt(data.get("downs")));
					comment.setGilded(getInt(data.get("gilded")));
					comment.setContoversiality(getInt(data.get("controversiality")));
					comment.setLikes(getInt(data.get("likes")));
					comment.setReplies(getInt(data.get("replies")));
					comment.setReports(getInt(data.get("num_reports")));
					comment.setSaved(getBoolean(data.get("saved")));
					comment.setEdited(getBoolean(data.get("edited")));
					comment.setScoreHidden(getBoolean(data.get("score_hidden")));
				}
			}
			return comment;
		}
	}
}
