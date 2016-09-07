package com.example.bigmercu.perfectmodel.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.bigmercu.perfectmodel.RxUnitTestTools;
import com.example.bigmercu.perfectmodel.contract.UserInfoContract;
import com.example.bigmercu.perfectmodel.model.db.GithubUser;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

/**
 * Created by bigmercu on 2016/9/6.
 * Email: bigmercu@gmail.com
 */
public class UserInfoPresenterTest {
    private UserInfoPresenter mUserInfoPresenter;
    private UserInfoContract.UserInfoView mUserInfoView;

    private GithubUser mGithubUserTest = new GithubUser() {
        @Override
        public long id() {
            return 7405217;
        }

        @NonNull
        @Override
        public String login() {
            return "Bigmercu";
        }

        @Nullable
        @Override
        public String avatar_url() {
            return "https://avatars.githubusercontent.com/u/7405217?v=3";
        }

        @Nullable
        @Override
        public String url() {
            return  "https://api.github.com/users/Bigmercu";
        }

        @Nullable
        @Override
        public String blog() {
            return "http://bigmercu.top";
        }

        @Nullable
        @Override
        public String location() {
            return "GuiZhou";
        }

        @Nullable
        @Override
        public Long public_repos() {
            return 14L;
        }

        @Nullable
        @Override
        public Long followers() {
            return 5L;
        }

        @Nullable
        @Override
        public Long following() {
            return 2L;
        }

        @Nullable
        @Override
        public String email() {
            return "bigmercu@gmail.com";
        }

        @Nullable
        @Override
        public String bio() {
            return " the quieter you become,the more you are able to hear";
        }

        @Nullable
        @Override
        public String repos_url() {
            return "https://api.github.com/users/Bigmercu/repos";
        }

        @Nullable
        @Override
        public String name() {
            return "Wallace";
        }

        @Nullable
        @Override
        public String created_at() {
            return "2014-04-25T12:14:13Z";
        }
    };



    @Before
    public void setUp() throws Exception {
        RxUnitTestTools.openRxTools();

        mUserInfoView = mock(UserInfoContract.UserInfoView.class);

        mUserInfoPresenter = new UserInfoPresenter(mUserInfoView);
    }

    @Test
    public void onSuccess() throws Exception {

        Mockito.verify(mUserInfoPresenter).onSuccess(mGithubUserTest);

    }

}