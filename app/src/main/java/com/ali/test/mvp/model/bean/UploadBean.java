package com.ali.test.mvp.model.bean;

/**
 * Created by mumu on 2019/3/15.
 */

public class UploadBean {

    /**
     * headPath : http://172.17.8.100/images/small/head_pic/2019-03-15/20190315143753.png
     * message : 上传成功
     * status : 0000
     */

    private java.lang.String headPath;
    private java.lang.String message;
    private java.lang.String status;

    public java.lang.String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(java.lang.String headPath) {
        this.headPath = headPath;
    }

    public java.lang.String getMessage() {
        return message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    @Override
    public java.lang.String toString() {
        return "UploadBean{" +
                "headPath='" + headPath + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
