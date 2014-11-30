package com.prnapps.javautils.reddit.domain.listing;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.prnapps.javautils.reddit.api.ApiGateway;
import com.prnapps.javautils.reddit.domain.thing.AbstractThing;
import com.prnapps.javautils.reddit.domain.thing.Comment;
import com.prnapps.javautils.reddit.domain.thing.Link;
import com.prnapps.javautils.reddit.domain.thing.ThingType;
import com.prnapps.javautils.utils.AbstractJsonDeserializer;

public class Saved extends AbstractListing {
	private List<AbstractThing> listing;

	public List<AbstractThing> getListing() {
		return listing;
	}
	public void setListing(List<AbstractThing> listing) {
		this.listing = listing;
	}
	public void addListing(AbstractThing...things) {
		if(listing == null) {
			listing = new ArrayList<AbstractThing>();
		}
		listing.addAll(Arrays.asList(things));
	}
	
	public static class SavedDeserializer extends AbstractJsonDeserializer<Saved> {
		@Override
		public Saved deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
			Saved saved = new Saved();
			JsonObject object = getJsonObject(element);
			if(object != null) {
				JsonObject data = getJsonObject(object.get("data"));
				if(data != null) {
					saved.setAfter(getString(data.get("after")));
					saved.setBefore(getString(data.get("before")));
					List<AbstractThing> listing = new ArrayList<AbstractThing>();
					JsonArray children = getJsonArray(data.get("children"));
					for(JsonElement child : children) {
						JsonObject obj = getJsonObject(child);
						if(obj != null) {
							String kind = getString(obj.get("kind"));
							if(ThingType.COMMENT.toString().equals(kind)) {
								Comment comment = context.deserialize(child, Comment.class);
								listing.add(comment);
							} else if(ThingType.LINK.toString().equals(kind)) {
								Link link = context.deserialize(child, Link.class);
								listing.add(link);
							}
						}
					}
					saved.setListing(listing);
				}
			}
			return saved;
		}
	}
}