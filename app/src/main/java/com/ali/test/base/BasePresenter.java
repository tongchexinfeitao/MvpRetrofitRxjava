package com.ali.test.base;

/**
 * Created by mumu on 2019/3/19.
 */

public abstract class BasePresenter<V extends IBaseView> {
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
        initModel();
    }

    protected abstract void initModel();

    //释放activity的引用
    public void onDestroy() {
        view = null;
    }

}
