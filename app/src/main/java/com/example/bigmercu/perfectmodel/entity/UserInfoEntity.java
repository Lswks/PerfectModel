package com.example.bigmercu.perfectmodel.entity;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

@AutoValue
public abstract class UserInfoEntity {
    /**
     * login : Bigmercu
     * id : 7405217
     * avatar_url : https://avatars.githubusercontent.com/u/7405217?v=3
     * gravatar_id :
     * url : https://api.github.com/users/Bigmercu
     * html_url : https://github.com/Bigmercu
     * followers_url : https://api.github.com/users/Bigmercu/followers
     * following_url : https://api.github.com/users/Bigmercu/following{/other_user}
     * gists_url : https://api.github.com/users/Bigmercu/gists{/gist_id}
     * starred_url : https://api.github.com/users/Bigmercu/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/Bigmercu/subscriptions
     * organizations_url : https://api.github.com/users/Bigmercu/orgs
     * repos_url : https://api.github.com/users/Bigmercu/repos
     * events_url : https://api.github.com/users/Bigmercu/events{/privacy}
     * received_events_url : https://api.github.com/users/Bigmercu/received_events
     * type : User
     * site_admin : false
     * name : Wallace
     * company : null
     * blog : http://bigmercu.top
     * location : GuiZhou
     * email : bigmercu@gmail.com
     * hireable : null
     * bio :  the quieter you become,the more you are able to hear
     * public_repos : 13
     * public_gists : 0
     * followers : 5
     * following : 1
     * created_at : 2014-04-25T12:14:13Z
     * updated_at : 2016-09-03T03:01:00Z
     */

    @SerializedName("login") public abstract String login();
    @SerializedName("id") public abstract int id();
    @Nullable @SerializedName("avatar_url") public abstract String avatar_url();
    @Nullable @SerializedName("gravatar_id") public abstract String gravatar_id();
    @Nullable @SerializedName("url") public abstract String url();
    @Nullable @SerializedName("html_url") public abstract String html_url();
    @Nullable @SerializedName("followers_url") public abstract String followers_url();
    @Nullable @SerializedName("following_url") public abstract String following_url();
    @Nullable @SerializedName("gists_url") public abstract String gists_url();
    @Nullable @SerializedName("starred_url") public abstract String starred_url();
    @Nullable @SerializedName("subscriptions_url") public abstract String subscriptions_url();
    @Nullable @SerializedName("organizations_url") public abstract String organizations_url();
    @Nullable @SerializedName("repos_url") public abstract String repos_url();
    @Nullable @SerializedName("events_url") public abstract String events_url();
    @Nullable @SerializedName("received_events_url") public abstract String received_events_url();
    @Nullable @SerializedName("type") public abstract String type();
    @SerializedName("site_admin") public abstract boolean site_admin();
    @Nullable @SerializedName("name") public abstract String name();
    @Nullable @SerializedName("company") public abstract Object company();
    @Nullable @SerializedName("blog") public abstract String blog();
    @Nullable @SerializedName("location") public abstract String location();
    @Nullable @SerializedName("email") public abstract String email();
    @Nullable @SerializedName("hireable") public abstract Object hireable();
    @Nullable @SerializedName("bio") public abstract String bio();
    @SerializedName("public_repos") public abstract long public_repos();
    @SerializedName("public_gists") public abstract int public_gists();
    @SerializedName("followers") public abstract long followers();
    @SerializedName("following") public abstract long following();
    @Nullable @SerializedName("created_at") public abstract String created_at();
    @Nullable @SerializedName("updated_at") public abstract String updated_at();

    public static TypeAdapter<UserInfoEntity> typeAdapter(Gson gson) {
        return new AutoValue_UserInfoEntity.GsonTypeAdapter(gson);
    }

}
