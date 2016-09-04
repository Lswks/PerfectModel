package com.example.bigmercu.perfectmodel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bigmercu.perfectmodel.R;
import com.example.bigmercu.perfectmodel.contract.UserInfoContract;
import com.example.bigmercu.perfectmodel.presenter.UserInfoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements UserInfoContract.UserInfoView {

    private UserInfoContract.UserInfoPresenter mUserInfoPresenter;

    @BindView(R.id.button)
    Button mButton;

    @BindView(R.id.editText)
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new UserInfoPresenter(this);
    }

    @OnClick(R.id.button)
    public void setButtonClick(){
        Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_SHORT).show();
        mUserInfoPresenter.getUserInfo("bigmercu");
    }

    @Override
    public void setUserInfo(String name) {

    }

    @Override
    public void setPresenter(UserInfoContract.UserInfoPresenter presenter) {
        mUserInfoPresenter = presenter;
    }
}

    /**
     * 测试MyAdapterFactory
     *
     *   Gson gson = new GsonBuilder()
     .registerTypeAdapterFactory(MyAdapterFactory.create())
     .create();
     String json = "{\n" +
     "  \"login\": \"Bigmercu\",\n" +
     "  \"id\": 7405217,\n" +
     "  \"avatar_url\": \"https://avatars.githubusercontent.com/u/7405217?v=3\",\n" +
     "  \"gravatar_id\": \"\",\n" +
     "  \"url\": \"https://api.github.com/users/Bigmercu\",\n" +
     "  \"html_url\": \"https://github.com/Bigmercu\",\n" +
     "  \"followers_url\": \"https://api.github.com/users/Bigmercu/followers\",\n" +
     "  \"following_url\": \"https://api.github.com/users/Bigmercu/following{/other_user}\",\n" +
     "  \"gists_url\": \"https://api.github.com/users/Bigmercu/gists{/gist_id}\",\n" +
     "  \"starred_url\": \"https://api.github.com/users/Bigmercu/starred{/owner}{/repo}\",\n" +
     "  \"subscriptions_url\": \"https://api.github.com/users/Bigmercu/subscriptions\",\n" +
     "  \"organizations_url\": \"https://api.github.com/users/Bigmercu/orgs\",\n" +
     "  \"repos_url\": \"https://api.github.com/users/Bigmercu/repos\",\n" +
     "  \"events_url\": \"https://api.github.com/users/Bigmercu/events{/privacy}\",\n" +
     "  \"received_events_url\": \"https://api.github.com/users/Bigmercu/received_events\",\n" +
     "  \"type\": \"User\",\n" +
     "  \"site_admin\": false,\n" +
     "  \"name\": \"Wallace\",\n" +
     "  \"company\": null,\n" +
     "  \"blog\": \"http://bigmercu.top\",\n" +
     "  \"location\": \"GuiZhou\",\n" +
     "  \"email\": \"bigmercu@gmail.com\",\n" +
     "  \"hireable\": null,\n" +
     "  \"bio\": \" the quieter you become,the more you are able to hear\",\n" +
     "  \"public_repos\": 14,\n" +
     "  \"public_gists\": 0,\n" +
     "  \"followers\": 5,\n" +
     "  \"following\": 1,\n" +
     "  \"created_at\": \"2014-04-25T12:14:13Z\",\n" +
     "  \"updated_at\": \"2016-09-03T03:01:00Z\"\n" +
     "}";
     UserInfoEntity userInfoEntity = gson.fromJson(json,UserInfoEntity.class);
     UserInfoEntity userInfoEntity1 = gson.fromJson(json,UserInfoEntity.class);
     * */

