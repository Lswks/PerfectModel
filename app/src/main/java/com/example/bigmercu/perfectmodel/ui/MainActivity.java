package com.example.bigmercu.perfectmodel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bigmercu.perfectmodel.R;
import com.example.bigmercu.perfectmodel.contract.UserInfoContract;
import com.example.bigmercu.perfectmodel.model.db.GithubUser;
import com.example.bigmercu.perfectmodel.presenter.UserInfoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements UserInfoContract.UserInfoView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private UserInfoContract.UserInfoPresenter mUserInfoPresenter;

    @BindView(R.id.button)
    Button mButton;

    @BindView(R.id.editText)
    EditText mEditText;

    @BindView(R.id.name)
    TextView mName;

    @BindView(R.id.bio)
    TextView mbio;

    @BindView(R.id.blog)
    TextView mBlog;

    @BindView(R.id.created_at)
    TextView mCreatedAt;

    @BindView(R.id.email)
    TextView mEmail;

    @BindView(R.id.location)
    TextView mLocation;

    @BindView(R.id.repos)
    TextView mRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        new UserInfoPresenter(this);
    }

    @OnClick(R.id.button)
    public void setButtonClick(){
        if(mName.getText() != null)
            mUserInfoPresenter.getUserInfo(String.valueOf(mEditText.getText()));
    }



    @Override
    public void setPresenter(UserInfoContract.UserInfoPresenter presenter) {
        mUserInfoPresenter = presenter;
    }

    @Override
    public void setUserInfo(GithubUser mGithubUser) {
        mName.setText(mGithubUser.name() + "(" + mGithubUser.login() + ")");
        mbio.setText(mGithubUser.bio());
        mBlog.setText(mGithubUser.blog());
        mLocation.setText(mGithubUser.location());
        mEmail.setText(mGithubUser.email());
        mCreatedAt.setText(mGithubUser.created_at());
        mRepos.setText(mGithubUser.public_repos().toString());
    }

    @Override
    public void onFiled(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}