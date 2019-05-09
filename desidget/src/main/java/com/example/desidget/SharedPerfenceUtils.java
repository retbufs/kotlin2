package com.example.desidget;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class SharedPerfenceUtils {
    private static SharedPerfenceUtils mInstance = null;
    private String fileName = "sharedPerfence";
    private Context context;
    private static SharedPreferences mSharedPreferences;

    /**
     * 使用当前工具类 必须对当前对象进行出初始化操作
     *
     * @param context
     * @param fileName
     * @return
     */
    public static SharedPerfenceUtils init(Context context, String fileName) {
        if (context == null) {
            throw new IllegalArgumentException("当前Context为初始化");
        } else {
            if (mInstance == null) {
                synchronized (SharedPerfenceUtils.class) {
                    if (mInstance == null) {
                        mInstance = new SharedPerfenceUtils(context);
                        mSharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
                    }
                }
            }
        }
        return mInstance;
    }

    /**
     * 自定一输入文件保存名
     *
     * @param context
     * @param fileName
     */
    private  SharedPerfenceUtils(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    /**
     * 使用默认文件名保存
     *
     * @param context
     */
    private SharedPerfenceUtils(Context context) {
        this.context = context;
        this.fileName = fileName;
    }

    /**
     * 获取当前对象的单列
     *
     * @return
     */
    public static SharedPerfenceUtils getInstance() {
        return mInstance;
    }
    /**
     * @param key
     * @param obj
     */
    public void put(String key, Object obj) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (obj instanceof String) {
            editor.putString(key, (String) obj);
        } else if (obj instanceof Boolean) {
            editor.putBoolean(key, Boolean.TRUE);
        } else if (obj instanceof Float) {
            editor.putFloat(key, (Float) obj);
        } else if (obj instanceof Long) {
            editor.putLong(key, (Long) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj);
        } else if (obj instanceof Set) {
            editor.putStringSet(key, (Set<String>) obj);
        } else {
            editor.putString(key, (String) obj);
        }
        editor.commit();
        //这里需要优化
        editor.apply();
    }
    /**
     * @param key
     * @param obj
     * @return
     */
    public Object get(String key, Object obj) {
        SharedPreferences sharedPreferences = mSharedPreferences;
        if (obj instanceof String) {
            return sharedPreferences.getString(key, (String) obj);
        } else if (obj instanceof Boolean) {
            return sharedPreferences.getBoolean(key, Boolean.TRUE);
        } else if (obj instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) obj);
        } else if (obj instanceof Long) {
            return sharedPreferences.getLong(key, (Long) obj);
        } else if (obj instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) obj);
        } else if (obj instanceof Set) {
            return (Object) sharedPreferences.getStringSet(key, (Set<String>) obj);
        } else {
            return sharedPreferences.getString(key, (String) obj);
        }
    }
}
