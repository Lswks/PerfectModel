package com.example.bigmercu.perfectmodel.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bigmercu.perfectmodel.R;
import com.example.bigmercu.perfectmodel.contract.SearchRepoContract;
import com.example.bigmercu.perfectmodel.presenter.SearchRepoPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SearchRepoContract.SearchRepoView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private SearchRepoContract.SearchRepoPresenter mSearchRepoPresenter;

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
        new SearchRepoPresenter(this);
    }

    @OnClick(R.id.button)
    public void setButtonClick(){
        if(mName.getText() != null)
            mSearchRepoPresenter.searchRepo(mEditText.getText().toString());
    }

    @Override
    public void onGetRepoData() {

    }

    @Override
    public void setPresenter(SearchRepoContract.SearchRepoPresenter presenter) {
        this.mSearchRepoPresenter = presenter;
    }
}