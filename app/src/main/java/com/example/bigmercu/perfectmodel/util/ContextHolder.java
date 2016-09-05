package com.example.bigmercu.perfectmodel.util;

import android.content.Context;

/**
 * Created by bigmercu on 2016/9/4.
 * Email: bigmercu@gmail.com
 */

public class ContextHolder {
    static Context ApplicationContext;
    public static void initial(Context context) {
        ApplicationContext = context;
    }
    public static Context getContext() {
        return ApplicationContext;
    }
}