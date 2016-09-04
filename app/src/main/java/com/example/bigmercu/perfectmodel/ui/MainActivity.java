package com.example.bigmercu.perfectmodel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
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
        mUserInfoPresenter.getUserInfo("Bigmercu");
    }



    @Override
    public void setPresenter(UserInfoContract.UserInfoPresenter presenter) {
        mUserInfoPresenter = presenter;
    }

    @Override
    public void setUserInfo(GithubUser mGithubUser) {
        Log.d(TAG,mGithubUser.toString());
    }

    @Override
    public void onFiled(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}