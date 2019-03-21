package com.ali.test.mvp.model.api;

import com.ali.test.mvp.model.bean.UploadBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by mumu on 2019/3/15.
 */

public interface IUploadApi {

    @Multipart
    @POST("user/verify/v1/modifyHeadPic")
    Observable<UploadBean> upLoad(@Header("userId") java.lang.String userId, @Header("sessionId") java.lang.String sessionId, @Part MultipartBody.Part part);
}
