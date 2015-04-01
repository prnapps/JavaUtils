package com.prnapps.javautils.imgur.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/31/2015.
 */
public class BasicResponse<D> {
    @Expose
    private int status;
    @Expose
    private boolean success;
    @Expose
    private D data;

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public D getData() {
        return data;
    }
    public void setData(D data) {
        this.data = data;
    }

}
