package com.prnapps.javautils.imgur.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by jimbo on 3/30/2015.
 */
public abstract class AbstractResponse {
    @Expose
    private boolean success;
    @Expose
    private int status;
    @Expose
    private Error error;

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

}
