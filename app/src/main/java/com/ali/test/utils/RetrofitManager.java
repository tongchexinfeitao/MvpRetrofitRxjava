package com.ali.test.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mumu on 2019/3/15.
 */

public class RetrofitManager {

    private static final String BASE_URL = "http://172.17.8.100/small/";
    Retrofit mRetrofit;


    private static class SingleHolder {
        private static final RetrofitManager INSTANCE = new RetrofitManager();
}

    public static RetrofitManager getInstance() {
        return SingleHolder.INSTANCE;
    }

    private RetrofitManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(buildOkhttpClient())
                //添加转换器  gSON
                .addConverterFactory(GsonConverterFactory.create())
                //使Retrofit支持Rxjava2链式调用
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient buildOkhttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }


    public <T> T create(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }
}
