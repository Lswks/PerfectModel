package com.example.bigmercu.perfectmodel.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bigmercu.perfectmodel.R;
import com.example.bigmercu.perfectmodel.contract.SearchRepoContract;
import com.example.bigmercu.perfectmodel.entry.SearchEntry;
import com.example.bigmercu.perfectmodel.presenter.SearchRepoPresenter;
import com.example.bigmercu.perfectmodel.ui.adapter.RepoAdapter;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.bigmercu.perfectmodel.R.id.fab;

public class SearchActivity extends RxAppCompatActivity implements SearchRepoContract.SearchRepoView {

    public static final int VIWE_TYPE_SEARCH = 1;
    public static final int VIWE_TYPE_NULL = 2;
    public static final int VIWE_TYPE_CONTENT = 3;


    private Unbinder mUnbinder;

    private SearchRepoContract.SearchRepoPresenter mSearchRepoPresenter;

    @BindView(R.id.repos)
    RecyclerView mRecyclerView;

    @BindView(fab)
    FloatingActionButton mFloatingActionButton;


    private RepoAdapter mRepoAdapter;
    private List<SearchEntry.ItemsBean> mItemsBeanList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUnbinder = ButterKnife.bind(this);

        new SearchRepoPresenter(this);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.smoothScrollToPosition(0);
            }
        });

        initView();
    }

    private void initView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRepoAdapter = new RepoAdapter(this,mItemsBeanList);
        mRecyclerView.setAdapter(mRepoAdapter);
        mRepoAdapter.setOnItemClickLitener(new RepoAdapter.OnItemClickLitener() {
            @Override
            public void OnSearchClick(View view, String data) {
                mSearchRepoPresenter.searchRepo(data);
            }
        });
    }

    @Override
    public void setPresenter(SearchRepoContract.SearchRepoPresenter presenter) {
        this.mSearchRepoPresenter = presenter;
    }

    @Override
    public void onGetRepoData(List<SearchEntry.ItemsBean> s) {
        mItemsBeanList.clear();
        mItemsBeanList.addAll(s);
        mRepoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFiled(String msg) {
        Snackbar.make(mRecyclerView, msg, Snackbar.LENGTH_LONG)
                .setAction("GET", null).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
