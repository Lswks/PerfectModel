package com.example.bigmercu.perfectmodel.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.bigmercu.perfectmodel.R;
import com.example.bigmercu.perfectmodel.contract.SearchRepoContract;
import com.example.bigmercu.perfectmodel.entry.SearchEntry;
import com.example.bigmercu.perfectmodel.ui.adapter.RepoAdapter;

import butterknife.BindView;

public class SearchActivity extends AppCompatActivity implements SearchRepoContract.SearchRepoView {

    public static final int VIWE_TYPE_SEARCH = 1;
    public static final int VIWE_TYPE_NULL = 2;
    public static final int VIWE_TYPE_CONTENT = 3;

    private SearchRepoContract.SearchRepoPresenter mSearchRepoPresenter;

    @BindView(R.id.repos)
    RecyclerView mRecyclerView;


    private RepoAdapter mRepoAdapter;
    private SearchEntry mSearchEntry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRepoAdapter = new RepoAdapter(this,mSearchEntry);
    }

    @Override
    public void setPresenter(SearchRepoContract.SearchRepoPresenter presenter) {
        this.mSearchRepoPresenter = presenter;
    }

    @Override
    public void onGetRepoData(SearchEntry searchEntry) {

    }

    @Override
    public void onFiled(String msg) {
        Snackbar.make(mRecyclerView, msg, Snackbar.LENGTH_LONG)
                .setAction("GET", null).show();
    }
}
