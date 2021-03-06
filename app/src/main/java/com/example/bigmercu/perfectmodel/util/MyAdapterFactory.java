package com.example.bigmercu.perfectmodel.util;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by bigmercu on 2016/9/4.
 * Email: bigmercu@gmail.com
 */

@GsonTypeAdapterFactory
public abstract class MyAdapterFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create() {
        return new AutoValueGson_MyAdapterFactory();
    }

}