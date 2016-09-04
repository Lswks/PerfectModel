package com.example.bigmercu.perfectmodel.presenter;

import com.example.bigmercu.perfectmodel.contract.UserInfoContract;
import com.example.bigmercu.perfectmodel.model.UserInfoModel;
import com.example.bigmercu.perfectmodel.model.db.GithubUser;
import com.example.bigmercu.perfectmodel.model.impl.UserInfoModelImpl;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public class UserInfoPresenter implements UserInfoContract.UserInfoPresenter,UserInfoModel.onGetDataListener{

    UserInfoContract.UserInfoView mUserInfoView;
    UserInfoModelImpl mUserInfoModel;

    public UserInfoPresenter(UserInfoContract.UserInfoView view){
        this.mUserInfoView = view;
        mUserInfoModel = UserInfoModelImpl.getInstance();
        mUserInfoView.setPresenter(this);
    }

    @Override
    public void getUserInfo(String name) {
        mUserInfoModel.getUserInfo(name,this);
    }

    @Override
    public void start() {
//        mUserInfoView.setUserInfo();
    }

    @Override
    public void onSuccess(GithubUser mGithubUser) {
        mUserInfoView.setUserInfo(mGithubUser);
    }

    @Override
    public void onFiled(String msg) {
        mUserInfoView.onFiled(msg);
    }
}
