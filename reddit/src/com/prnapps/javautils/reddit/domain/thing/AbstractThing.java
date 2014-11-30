package com.prnapps.javautils.reddit.domain.thing;

public class AbstractThing {
	protected String kind;
	protected String id;

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullname() {
		return kind + "_" + id;
	}
	public void setFullname(String fullname) {
		String[] split = fullname.split("_", 2);
		this.kind = split[0];
		this.id = split[1];
	}
}