package com.prnapps.javautils.imgur.domain;

/**
 * Created by jimbo on 3/31/2015.
 */
public class BasicResponse<D> {
    private int status;
    private boolean success;
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
