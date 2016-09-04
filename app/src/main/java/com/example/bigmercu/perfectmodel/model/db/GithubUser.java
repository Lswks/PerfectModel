package com.example.bigmercu.perfectmodel.model.db;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.bigmercu.perfectmodel.GithubUserModel;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.squareup.sqldelight.RowMapper;

/**
 * Created by bigmercu on 2016/9/4.
 * Email: bigmercu@gmail.com
 */
@AutoValue
public abstract class GithubUser implements GithubUserModel {
    public static final Factory<GithubUser> FACTORY = new Factory<>(new Creator<GithubUser>() {
        @Override
        public GithubUser create(long id, @NonNull String login, @Nullable String avatar_url,
                                 @Nullable String url, @Nullable String blog, @Nullable String location,
                                 @Nullable Long public_repos, @Nullable Long followers, @Nullable Long following,
                                 @Nullable String email, @Nullable String bio, @Nullable String repos_url,
                                 @Nullable String name, @Nullable String created_at) {
            return new AutoValue_GithubUser(id,login,avatar_url,url,blog,location,public_repos,
                    followers,following,email,bio,repos_url,name,created_at);
        }
    });

    public static TypeAdapter<GithubUser> typeAdapter(final Gson gson){
        return new AutoValue_GithubUser.GsonTypeAdapter(gson);
    }

    public static final RowMapper<GithubUser> MAPPER = FACTORY.select_by_loginMapper();
}