package com.example.bigmercu.perfectmodel.model;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public interface UserInfoModel {
    void getUserInfo(String name,onGetDataListener listener);
    interface onGetDataListener<T>{
        void onSuccess(T entry);
        void onFiled(String msg);
    }
    void onCancle();
}
