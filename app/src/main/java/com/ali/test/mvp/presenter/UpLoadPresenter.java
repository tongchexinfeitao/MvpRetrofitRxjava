package com.ali.test.mvp.presenter;

import com.ali.test.base.BasePresenter;
import com.ali.test.mvp.contract.IUploadContract;
import com.ali.test.mvp.model.UploadModel;
import com.ali.test.mvp.model.bean.UploadBean;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mumu on 2019/3/19.
 */

public class UpLoadPresenter extends BasePresenter<IUploadContract.IView> implements IUploadContract.IPresenter {

    private UploadModel uploadModel;

    public UpLoadPresenter(IUploadContract.IView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        uploadModel = new UploadModel();
    }

    @Override
    public void upload(java.lang.String userId, java.lang.String sessionId, File file) {
        uploadModel.upload(userId, sessionId, file)
                //在子线程执行联网操作
                .subscribeOn(Schedulers.io())
                //设置在主线程接受事件
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<UploadBean>() {
                    @Override
                    public boolean test(UploadBean uploadBean) throws Exception {
                        return uploadBean.getStatus().equals("0000");
                    }
                })
                .map(new Function<UploadBean, java.lang.String>() {
                    @Override
                    public java.lang.String apply(UploadBean uploadBean) throws Exception {
                        return uploadBean.getHeadPath();
                    }
                })

                .subscribe(new Consumer<java.lang.String>() {
                    @Override
                    public void accept(java.lang.String s) throws Exception {
                        //成功回调
                        if (view != null) {
                            view.success(s);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //失败回调
                        if (view != null) {
                            view.faild(throwable);
                        }
                    }
                });


    }
}
