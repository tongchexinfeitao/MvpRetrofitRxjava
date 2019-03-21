package com.ali.test.mvp.model.bean;

/**
 * Created by mumu on 2019/3/15.
 */

public class RegisterBean {

    /**
     * message : 注册成功
     * status : 0000
     */

    private UploadBean message;
    private UploadBean status;

    public UploadBean getMessage() {
        return message;
    }

    public void setMessage(UploadBean message) {
        this.message = message;
    }

    public UploadBean getStatus() {
        return status;
    }

    public void setStatus(UploadBean status) {
        this.status = status;
    }

}
