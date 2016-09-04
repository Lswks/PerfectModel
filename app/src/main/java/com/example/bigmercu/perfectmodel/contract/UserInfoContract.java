package com.example.bigmercu.perfectmodel.contract;

import com.example.bigmercu.perfectmodel.base.BasePresenter;
import com.example.bigmercu.perfectmodel.base.BaseView;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public interface UserInfoContract {
    interface UserInfoPresenter extends BasePresenter{
        void getUserInfo(String name);
    }

    interface UserInfoView extends BaseView<UserInfoPresenter>{
        void setUserInfo(String name);
    }
}
