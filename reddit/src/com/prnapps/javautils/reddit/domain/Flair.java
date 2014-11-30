package com.prnapps.javautils.reddit.domain;

public class Flair {
	private String text;
	private String cssClass;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
}