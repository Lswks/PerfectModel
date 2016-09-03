package com.example.bigmercu.perfectmodel.model.impl;

import com.example.bigmercu.perfectmodel.model.UserInfoModel;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public class UserInfoModelImpl implements UserInfoModel {

    public static UserInfoModelImpl getInstance(){
        return UserInfoModelImplInstanceHolder.userInfoModel;
    }

    public static class UserInfoModelImplInstanceHolder{
        private static UserInfoModelImpl userInfoModel = new UserInfoModelImpl();
    }

    @Override
    public void getUserInfo() {

    }
}
