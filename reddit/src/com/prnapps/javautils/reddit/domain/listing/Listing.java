package com.prnapps.javautils.reddit.domain.listing;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by jimbo on 3/20/2015.
 */
public class Listing {
    @Expose
    private String kind;
    @Expose
    private ListingData data;
    @Expose
    protected List<List<String>> errors;

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public ListingData getData() {
        return data;
    }
    public void setData(ListingData data) {
        this.data = data;
    }
    public List<List<String>> getErrors() {
        return errors;
    }
    public void setErrors(List<List<String>> errors) {
        this.errors = errors;
    }

}
