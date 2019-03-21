package com.ali.test.mvp.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ali.test.R;
import com.ali.test.base.BaseActivity;
import com.ali.test.mvp.contract.IUploadContract;
import com.ali.test.mvp.presenter.UpLoadPresenter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends BaseActivity<UpLoadPresenter> implements IUploadContract.IView {

    @Override
    protected UpLoadPresenter providePresenter() {
        return new UpLoadPresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    //点击事件
    public void upload(View view) throws IOException {
        File file = getFile();
        presenter.upload("1671", "15526317221861671", file);
    }


    public File getFile() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        String defaultPath = getApplicationContext().getFilesDir()
                .getAbsolutePath() + "/defaultGoodInfo";
        File file = new File(defaultPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String defaultImgPath = defaultPath + "/messageImg.jpg";
        file = new File(defaultImgPath);
        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 20, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }


    @Override
    public void success(String headUrl) {
        Toast.makeText(MainActivity.this, "onNext", Toast.LENGTH_LONG).show();
        Log.e("tag", headUrl);
    }

    @Override
    public void faild(Throwable t) {
        Log.e("tag", t.toString());
    }
}
