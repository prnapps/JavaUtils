package com.prnapps.javautils.reddit.domain.thing;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.prnapps.javautils.reddit.domain.Errors;
import com.prnapps.javautils.utils.AbstractJsonDeserializer;

public class User extends AbstractThing {
	private String name;
	private Date created;
	private Errors errors;
	private int linkKarma;
	private int commentKarma;
	private boolean friend;
	private boolean gold;
	private boolean mod;
	private boolean verifiedEmail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
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
	public boolean isFriend() {
		return friend;
	}
	public void setFriend(boolean friend) {
		this.friend = friend;
	}
	public boolean isGold() {
		return gold;
	}
	public void setGold(boolean gold) {
		this.gold = gold;
	}
	public boolean isMod() {
		return mod;
	}
	public void setMod(boolean mod) {
		this.mod = mod;
	}
	public boolean isVerifiedEmail() {
		return verifiedEmail;
	}
	public void setVerifiedEmail(boolean verifiedEmail) {
		this.verifiedEmail = verifiedEmail;
	}
	public Errors getErrors() {
		return errors;
	}
	public void setErrors(Errors errors) {
		this.errors = errors;
	}
	
	public static class AboutDeserializer extends AbstractJsonDeserializer<User> {
		@Override
		public User deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
			User user = new User();
			JsonObject object = getJsonObject(element);
			if(object != null) {
				user.setKind(getString(object.get("kind")));
				JsonObject data = getJsonObject(object.get("data"));
				if(data != null) {
					user.setId(getString(data.get("id")));
					user.setName(getString(data.get("name")));
					user.setCreated(new Date(getLong(data.get("created_utc")) * 1000));
					user.setLinkKarma(getInt(data.get("link_karma")));
					user.setCommentKarma(getInt(data.get("comment_karma")));
					user.setFriend(getBoolean(data.get("is_friend")));
					user.setGold(getBoolean(data.get("is_gold")));
					user.setMod(getBoolean(data.get("is_mod")));
					user.setVerifiedEmail(getBoolean(data.get("has_verified_email")));
				}
			}
			return user;
		}
	}
}