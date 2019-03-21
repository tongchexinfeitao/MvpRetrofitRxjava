package com.ali.test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by mumu on 2019/3/19.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
        ButterKnife.bind(this);
        initView();
        initListener();
        presenter=providePresenter();
        initData();
    }

    protected abstract P providePresenter();

    protected abstract void initData();

    protected void initListener() {
    }

    protected void initView() {
    }

    protected abstract int provideLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放activity的引用
        if (presenter != null) {
            presenter.onDestroy();
        }
    }
}
