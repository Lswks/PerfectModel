package com.example.bigmercu.perfectmodel.model.impl;

import android.util.Log;

import com.example.bigmercu.perfectmodel.entity.UserInfoEntity;
import com.example.bigmercu.perfectmodel.model.UserInfoModel;
import com.example.bigmercu.perfectmodel.model.api.UserInfoService;
import com.example.bigmercu.perfectmodel.util.MyAdapterFactory;
import com.example.bigmercu.perfectmodel.util.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public class UserInfoModelImpl implements UserInfoModel {

    private static final String TAG = UserInfoModelImpl.class.getSimpleName();
    private UserInfoService mUserInfoService;
    Gson mGson=  new GsonBuilder().registerTypeAdapterFactory(MyAdapterFactory.create())
                                .create();

    public static UserInfoModelImpl getInstance(){
        return UserInfoModelImplInstanceHolder.userInfoModel;
    }

    public static class UserInfoModelImplInstanceHolder{
        private static UserInfoModelImpl userInfoModel = new UserInfoModelImpl();
    }

    public UserInfoModelImpl(){
        mUserInfoService = RetrofitClient.getInstance().create(UserInfoService.class);
    }

    @Override
    public void getUserInfo(String name) {
        mUserInfoService.getUserInfo(name)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ResponseBody, UserInfoEntity>() {
                    @Override
                    public UserInfoEntity call(ResponseBody responseBody) {
                        try {
                            return mGson.fromJson(responseBody.string(),UserInfoEntity.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }).subscribe(new Action1<UserInfoEntity>() {
            @Override
            public void call(UserInfoEntity userInfoEntity) {
                Log.d(TAG,userInfoEntity.name());
            }
        });
    }
}
