package com.example.bigmercu.perfectmodel.entry;

import android.support.annotation.Nullable;

import com.example.bigmercu.perfectmodel.util.AutoValueGson_MyAdapterFactory;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bigmercu on 2016/9/7.
 * Email: bigmercu@gmail.com
 */
@JsonAdapter(AutoValueGson_MyAdapterFactory.class)
@AutoValue
public abstract class SearchEntry{

    public @SerializedName("total_count") abstract int total_count();
    public @SerializedName("incomplete_results") abstract boolean incomplete_results();

    public abstract List<ItemsBean> items();

    @JsonAdapter(AutoValueGson_MyAdapterFactory.class)
    @AutoValue
    public abstract static class ItemsBean {
        public abstract int id();
        public abstract String name();
        public @Nullable abstract String full_name();
        public abstract OwnerBean owner();
        @SerializedName("private")
        public abstract boolean privateX();
        public @Nullable abstract String html_url();
        public @Nullable abstract String description();
        public abstract boolean fork();
        public @Nullable abstract String url();
        public @Nullable abstract String forks_url();
        public @Nullable abstract String keys_url();
        public @Nullable abstract String collaborators_url();
        public @Nullable abstract String teams_url();
        public @Nullable abstract String hooks_url();
        public @Nullable abstract String issue_events_url();
        public @Nullable abstract String events_url();
        public @Nullable abstract String assignees_url();
        public @Nullable abstract String branches_url();
        public @Nullable abstract String tags_url();
        public @Nullable abstract String blobs_url();
        public @Nullable abstract String git_tags_url();
        public @Nullable abstract String git_refs_url();
        public @Nullable abstract String trees_url();
        public @Nullable abstract String statuses_url();
        public @Nullable abstract String languages_url();
        public @Nullable abstract String stargazers_url();
        public @Nullable abstract String contributors_url();
        public @Nullable abstract String subscribers_url();
        public @Nullable abstract String subscription_url();
        public @Nullable abstract String commits_url();
        public @Nullable abstract String git_commits_url();
        public @Nullable abstract String comments_url();
        public @Nullable abstract String issue_comment_url();
        public @Nullable abstract String contents_url();
        public @Nullable abstract String compare_url();
        public @Nullable abstract String merges_url();
        public @Nullable abstract String archive_url();
        public @Nullable abstract String downloads_url();
        public @Nullable abstract String issues_url();
        public @Nullable abstract String pulls_url();
        public @Nullable abstract String milestones_url();
        public @Nullable abstract String notifications_url();
        public @Nullable abstract String labels_url();
        public @Nullable abstract String releases_url();
        public @Nullable abstract String deployments_url();
        public @Nullable abstract String created_at();
        public @Nullable abstract String updated_at();
        public @Nullable abstract String pushed_at();
        public @Nullable abstract String git_url();
        public @Nullable abstract String ssh_url();
        public @Nullable abstract String clone_url();
        public @Nullable abstract String svn_url();
        public @Nullable abstract String homepage();
        public abstract int size();
        public abstract int stargazers_count();
        public abstract int watchers_count();
        public @Nullable abstract String language();
        public abstract boolean has_issues();
        public abstract boolean has_downloads();
        public abstract boolean has_wiki();
        public abstract boolean has_pages();
        public abstract int forks_count();
        public @Nullable abstract Object mirror_url();
        public abstract int open_issues_count();
        public abstract int forks();
        public abstract int open_issues();
        public abstract int watchers();
        public @Nullable abstract String default_branch();
        public abstract double score();


        @JsonAdapter(AutoValueGson_MyAdapterFactory.class)
        @AutoValue
        public abstract static class OwnerBean {
            public abstract String login();
            public abstract int id();
            public @Nullable  abstract String avatar_url();
            public @Nullable  abstract String gravatar_id();
            public @Nullable  abstract String url();
            public @Nullable  abstract String html_url();
            public @Nullable  abstract String followers_url();
            public @Nullable  abstract String following_url();
            public @Nullable  abstract String gists_url();
            public @Nullable  abstract String starred_url();
            public @Nullable  abstract String subscriptions_url();
            public @Nullable  abstract String organizations_url();
            public @Nullable  abstract String repos_url();
            public @Nullable  abstract String events_url();
            public @Nullable  abstract String received_events_url();
            public @Nullable  abstract String type();
            public abstract boolean site_admin();
            public static TypeAdapter<OwnerBean> typeAdapter(Gson gson) {
                return new AutoValue_SearchEntry_ItemsBean_OwnerBean.GsonTypeAdapter(gson);
            }
        }
        public static TypeAdapter<ItemsBean> typeAdapter(Gson gson) {
            return new AutoValue_SearchEntry_ItemsBean.GsonTypeAdapter(gson);
        }
    }

    public static TypeAdapter<SearchEntry> typeAdapter(Gson gson) {
        return new AutoValue_SearchEntry.GsonTypeAdapter(gson);
    }
}
