package com.example.bigmercu.perfectmodel.model.impl;

import com.example.bigmercu.perfectmodel.contract.UserInfoContract;
import com.example.bigmercu.perfectmodel.model.db.GithubUser;
import com.example.bigmercu.perfectmodel.presenter.UserInfoPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by bigmercu on 2016/9/6.
 * Email: bigmercu@gmail.com
 */
public class UserInfoModelImplTest {

    private UserInfoModelImpl mUserInfoModel;

    private static final String TAG = UserInfoModelImplTest.class.getSimpleName();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getInstance() throws Exception {

    }

    @Test
    public void getUserInfo() throws Exception {
        UserInfoModelImpl model = Mockito.mock(UserInfoModelImpl.class);
        UserInfoPresenter userInfoPresenter = new UserInfoPresenter(new UserInfoContract.UserInfoView() {
            @Override
            public void setUserInfo(GithubUser mGithubUser) {

            }

            @Override
            public void onFiled(String msg) {

            }

            @Override
            public void setPresenter(UserInfoContract.UserInfoPresenter presenter) {

            }
        });

//        userInfoPresenter.setUserInfoModel(model);
//        UserInfoModel.onGetDataListener listener = userInfoPresenter.getListener();
//
//        userInfoPresenter.getUserInfo("Bigmercu");
//        Mockito.verify(model).getUserInfo("Bigmercu",listener);
    }

    @Test
    public void onCancle() throws Exception {
//        mUserInfoModel.onCancle();
    }

}