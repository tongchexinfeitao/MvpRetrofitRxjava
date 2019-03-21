package com.ali.test.mvp.contract;

import com.ali.test.base.IBaseView;
import com.ali.test.mvp.model.bean.UploadBean;

import java.io.File;

import io.reactivex.Observable;

/**
 * Created by mumu on 2019/3/19.
 */

public interface IUploadContract {

    interface IModel {
        Observable<UploadBean> upload(java.lang.String userId, java.lang.String sessionId, File file);
    }


    //presenter层暴露给view的方法l
    interface IPresenter {
        void upload(String userId, String sessionId, File file);
    }

    //view层暴露给presenter的方法
    interface IView extends IBaseView {
        void success(String headUrl);

        void faild(Throwable t);
    }
}
