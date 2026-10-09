package com.example.jiuzhaigou.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {
    private static final String SP_NAME = "user_info_sp";
    private static SharedPreferences sp;

    // 初始化SP
    private static void initSP(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
    }

    // 保存用户信息
    public static void saveUserInfo(Context context, String key, String value) {
        initSP(context);
        sp.edit().putString(key, value).apply();
    }

    // 获取用户信息
    public static String getUserInfo(Context context, String key) {
        initSP(context);
        return sp.getString(key, "");
    }

    // 清空用户信息（退出登录时用）
    public static void clearUserInfo(Context context) {
        initSP(context);
        sp.edit().clear().apply();
    }
}