package com.example.bigmercu.perfectmodel.model;

import com.example.bigmercu.perfectmodel.model.db.GithubUser;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public interface UserInfoModel {
    void getUserInfo(String name,onGetDataListener listener);
    interface onGetDataListener{
        void onSuccess(GithubUser mGithubUser);
        void onFiled(String msg);
    }
    void onCancle();
}
