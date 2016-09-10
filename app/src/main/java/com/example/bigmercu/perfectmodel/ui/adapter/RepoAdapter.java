package com.example.bigmercu.perfectmodel.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bigmercu.perfectmodel.R;
import com.example.bigmercu.perfectmodel.entry.SearchEntry;
import com.example.bigmercu.perfectmodel.ui.SearchActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bigmercu on 2016/9/8.
 * Email: bigmercu@gmail.com
 */

public class RepoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<SearchEntry.ItemsBean> mItemsBeanList;
    private OnItemClickLitener mOnSearchListener;
    private ContentViewHolder mContentViewHolder;

    public RepoAdapter(Context context, List<SearchEntry.ItemsBean> list){
        this.mContext = context;
        this.mItemsBeanList = list;
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnSearchListener = mOnItemClickLitener;
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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
       if(holder.getItemViewType() == SearchActivity.VIWE_TYPE_SEARCH){
           ((SearchHeaderViewHolder) holder).mButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(!((SearchHeaderViewHolder) holder).mEditText.getText().toString().equals("")){
                       mOnSearchListener.OnSearchClick(v,((SearchHeaderViewHolder) holder).mEditText.getText().toString());
                   }
               }
           });
       }else {
           mContentViewHolder = (ContentViewHolder) holder;
           mContentViewHolder.mName.setText(mItemsBeanList.get(position-1).owner().login()
                   + "/" + mItemsBeanList.get(position-1).name());
           mContentViewHolder.mLanguage.setText(mItemsBeanList.get(position-1).language());
           mContentViewHolder.mAuthor.setText(mItemsBeanList.get(position-1).owner().login());
           mContentViewHolder.mDesc.setText(mItemsBeanList.get(position-1).description());
           mContentViewHolder.mStar.setText(String.valueOf(mItemsBeanList.get(position-1).stargazers_count()));
           mContentViewHolder.mFork.setText(String.valueOf(mItemsBeanList.get(position-1).forks_count()));
       }
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? SearchActivity.VIWE_TYPE_SEARCH : SearchActivity.VIWE_TYPE_CONTENT;
    }

    @Override
    public int getItemCount() {
        return mItemsBeanList.size() + 1;
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

        @BindView(R.id.name)
        TextView mName;

        public ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface OnItemClickLitener{
        void OnSearchClick(View view,String data);
    }

}
