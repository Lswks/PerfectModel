package com.example.bigmercu.perfectmodel.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bigmercu.perfectmodel.R;
import com.example.bigmercu.perfectmodel.entry.SearchEntry;
import com.example.bigmercu.perfectmodel.ui.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bigmercu on 2016/9/8.
 * Email: bigmercu@gmail.com
 */

public class RepoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private SearchEntry mSearchEntry;

    public RepoAdapter(Context context, SearchEntry searchEntry){
        this.mContext = context;
        this.mSearchEntry = searchEntry;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == SearchActivity.VIWE_TYPE_CONTENT) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.repo_card, parent, false);
            return new ContentViewHolder(view);
        }else{
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.search_header, parent, false);
            return new SearchHeaderViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? SearchActivity.VIWE_TYPE_SEARCH : SearchActivity.VIWE_TYPE_CONTENT;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class SearchHeaderViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.search_content)
        EditText mEditText;

        @BindView(R.id.search_submit)
        Button mButton;

        public SearchHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.search_submit)
        public void Search(){
            Log.d("RepoAdapter","search");
        }

    }


    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fork)
        TextView mFork;

        @BindView(R.id.star)
        TextView mStar;

        @BindView(R.id.desc)
        TextView mDesc;

        @BindView(R.id.language)
        TextView mLanguage;

        @BindView(R.id.author)
        TextView mAuthor;

        public ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.card_rela)
        public void OnCardClick(){
            Log.d("RepoAdapter","onclik");
        }

    }

}
