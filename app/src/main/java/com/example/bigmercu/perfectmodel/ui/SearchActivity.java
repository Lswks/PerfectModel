package com.example.bigmercu.perfectmodel.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.bigmercu.perfectmodel.R;
import com.example.bigmercu.perfectmodel.contract.SearchRepoContract;
import com.example.bigmercu.perfectmodel.entry.SearchEntry;

import butterknife.BindView;

public class SearchActivity extends AppCompatActivity implements SearchRepoContract.SearchRepoView {

    private SearchRepoContract.SearchRepoPresenter mSearchRepoPresenter;

    @BindView(R.id.repos)
    RecyclerView mRecyclerView;

    @BindView(R.id.promptText)
    TextView mTextView;


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
