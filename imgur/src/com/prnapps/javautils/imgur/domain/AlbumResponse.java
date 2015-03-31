package com.prnapps.javautils.imgur.domain;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by jimbo on 3/30/2015.
 */
public class AlbumResponse extends AbstractResponse {
    @Expose
    private List<Image> data;

    public List<Image> getData() {
        return data;
    }
    public void setData(List<Image> data) {
        this.data = data;
    }

}
