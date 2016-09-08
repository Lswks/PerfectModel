package com.example.bigmercu.perfectmodel.entry;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bigmercu on 2016/9/7.
 * Email: bigmercu@gmail.com
 */

@AutoValue
public abstract class SearchEntry {

   @SerializedName("total_count") abstract int total_count();
   @SerializedName("incomplete_results") abstract boolean incomplete_results();

    abstract List<ItemsBean> items();

    @AutoValue
    public abstract static class ItemsBean {
        abstract int id();
        abstract String name();
        @Nullable abstract String full_name();
        abstract OwnerBean owner();
        @SerializedName("private")
        abstract boolean privateX();
        @Nullable abstract String html_url();
        @Nullable abstract String description();
        abstract boolean fork();
        @Nullable abstract String url();
        @Nullable abstract String forks_url();
        @Nullable abstract String keys_url();
        @Nullable abstract String collaborators_url();
        @Nullable abstract String teams_url();
        @Nullable abstract String hooks_url();
        @Nullable abstract String issue_events_url();
        @Nullable abstract String events_url();
        @Nullable abstract String assignees_url();
        @Nullable abstract String branches_url();
        @Nullable abstract String tags_url();
        @Nullable abstract String blobs_url();
        @Nullable abstract String git_tags_url();
        @Nullable abstract String git_refs_url();
        @Nullable abstract String trees_url();
        @Nullable abstract String statuses_url();
        @Nullable abstract String languages_url();
        @Nullable abstract String stargazers_url();
        @Nullable abstract String contributors_url();
        @Nullable abstract String subscribers_url();
        @Nullable abstract String subscription_url();
        @Nullable abstract String commits_url();
        @Nullable abstract String git_commits_url();
        @Nullable abstract String comments_url();
        @Nullable abstract String issue_comment_url();
        @Nullable abstract String contents_url();
        @Nullable abstract String compare_url();
        @Nullable abstract String merges_url();
        @Nullable abstract String archive_url();
        @Nullable abstract String downloads_url();
        @Nullable abstract String issues_url();
        @Nullable abstract String pulls_url();
        @Nullable abstract String milestones_url();
        @Nullable abstract String notifications_url();
        @Nullable abstract String labels_url();
        @Nullable abstract String releases_url();
        @Nullable abstract String deployments_url();
        @Nullable abstract String created_at();
        @Nullable abstract String updated_at();
        @Nullable abstract String pushed_at();
        @Nullable abstract String git_url();
        @Nullable abstract String ssh_url();
        @Nullable abstract String clone_url();
        @Nullable abstract String svn_url();
        @Nullable abstract String homepage();
        abstract int size();
        abstract int stargazers_count();
        abstract int watchers_count();
        @Nullable abstract String language();
        abstract boolean has_issues();
        abstract boolean has_downloads();
        abstract boolean has_wiki();
        abstract boolean has_pages();
        abstract int forks_count();
        @Nullable abstract Object mirror_url();
        abstract int open_issues_count();
        abstract int forks();
        abstract int open_issues();
        abstract int watchers();
        @Nullable abstract String default_branch();
        abstract double score();


        @AutoValue
        public abstract static class OwnerBean {
            abstract String login();
            abstract int id();
            @Nullable  abstract String avatar_url();
            @Nullable  abstract String gravatar_id();
            @Nullable  abstract String url();
            @Nullable  abstract String html_url();
            @Nullable  abstract String followers_url();
            @Nullable  abstract String following_url();
            @Nullable  abstract String gists_url();
            @Nullable  abstract String starred_url();
            @Nullable  abstract String subscriptions_url();
            @Nullable  abstract String organizations_url();
            @Nullable  abstract String repos_url();
            @Nullable  abstract String events_url();
            @Nullable  abstract String received_events_url();
            @Nullable  abstract String type();
            abstract boolean site_admin();
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
