package com.example.bigmercu.perfectmodel.model.db.test;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.bigmercu.perfectmodel.BigmecuTestModel;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.squareup.sqldelight.RowMapper;

/**
 * Created by bigmercu on 2016/9/9.
 * Email: bigmercu@gmail.com
 */

@AutoValue
public abstract class BigmercuTest implements BigmecuTestModel {
    public static final BigmercuTest.Factory<BigmercuTest> FACTORY = new Factory<>(new Creator<BigmercuTest>() {
        @Override
        public BigmercuTest create(long id, @NonNull String login, @Nullable Long age,
                                       @Nullable String email, @Nullable String name) {
            return new AutoValue_BigmercuTest(id,login,age,email,name);
        }
    });
    public static TypeAdapter<BigmercuTest> typeAdapter(final Gson gson){
        return new AutoValue_BigmercuTest.GsonTypeAdapter(gson);
    }

    public static final RowMapper<BigmercuTest> MAPPER = FACTORY.select_by_nameMapper();
}
