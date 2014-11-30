package com.prnapps.javautils.reddit.domain.thing;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.prnapps.javautils.utils.AbstractJsonDeserializer;

public class Media extends AbstractThing {
	private String title;
	private String description;
	private String html;
	private String authorName;
	private String authorUrl;
	private String providerUrl;
	private String providerName;
	private int height;
	private int width;
	private String thumbnailUrl;
	private int thumbnailWidth;
	private int thumbnailHeight;
	private String mediaType;
	private String version;
	
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
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorUrl() {
		return authorUrl;
	}
	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}
	public String getProviderUrl() {
		return providerUrl;
	}
	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
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
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public static class MediaDeserializer extends AbstractJsonDeserializer<Media> {
		@Override
		public Media deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
			Media media = new Media();
			JsonObject object = getJsonObject(element);
			if(object != null) {
				media.setKind(getString(object.get("type")));
				JsonObject data = getJsonObject(object.get("oembed"));
				if(data != null) {
					media.setTitle(getString(data.get("title")));
					media.setDescription(getString(data.get("description")));
					media.setHtml(getString(data.get("html")));
					media.setAuthorName(getString(data.get("author_name")));
					media.setAuthorUrl(getString(data.get("author_url")));
					media.setProviderName(getString(data.get("provider_name")));
					media.setProviderUrl(getString(data.get("provider_url")));
					media.setHeight(getInt(data.get("height")));
					media.setWidth(getInt(data.get("width")));
					media.setThumbnailHeight(getInt(data.get("thumbnail_height")));
					media.setThumbnailWidth(getInt(data.get("thumbnail_width")));
					media.setThumbnailUrl(getString(data.get("thumbnail_url")));
					media.setMediaType(getString(data.get("type")));
					media.setVersion(getString(data.get("version")));
				}
			}
			return media;
		}
	}
}
