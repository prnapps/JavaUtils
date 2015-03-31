package com.prnapps.javautils.imgur.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/30/2015.
 */
public class ImageResponse extends AbstractResponse {
    @Expose
    private Image data;

    public Image getData() {
        return data;
    }
    public void setData(Image data) {
        this.data = data;
    }

}