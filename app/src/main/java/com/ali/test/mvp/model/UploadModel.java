package com.ali.test.mvp.model;

import com.ali.test.mvp.contract.IUploadContract;
import com.ali.test.mvp.model.api.IUploadApi;
import com.ali.test.mvp.model.bean.UploadBean;
import com.ali.test.utils.RetrofitManager;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by mumu on 2019/3/19.
 */

public class UploadModel implements IUploadContract.IModel {

    @Override
    public Observable<UploadBean> upload(java.lang.String userId, java.lang.String sessionId, File file) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        // MultipartBody.Part封装了接受的key和文件名字和RequestBody
        MultipartBody.Part part = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
        return RetrofitManager.getInstance()
                .create(IUploadApi.class)
                .upLoad(userId, sessionId, part);
    }
}
