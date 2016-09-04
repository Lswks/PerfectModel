package com.example.bigmercu.perfectmodel.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public class RetrofitClient {
    private static String HOME_URL = "https://api.github.com/";

    public static RetrofitClient getInstance(){
        return RetrofitClientSingletonHolder.mRetrofitClient;
    }

    public static class RetrofitClientSingletonHolder{
        public static RetrofitClient mRetrofitClient = new RetrofitClient();
    }

    private Retrofit mRetrofit;

    public RetrofitClient(){
        createRetrofitClient();
    }

    private void createRetrofitClient() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(HOME_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<?> clazz) {
        return (T) mRetrofit.create(clazz);
    }
}
