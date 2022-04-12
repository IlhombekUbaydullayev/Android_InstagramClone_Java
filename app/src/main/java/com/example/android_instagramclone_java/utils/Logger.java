package com.example.android_instagramclone_java.utils;

import android.util.Log;

public class Logger {
    static Boolean IS_TESTER = true;
    public static void d(String tag, String msg) {
        if (IS_TESTER) Log.d(tag, msg);
    }

    void i(String tag,String msg) {
        if (IS_TESTER) Log.i(tag, msg);
    }

    void v(String tag,String msg) {
        if (IS_TESTER) Log.v(tag, msg);
    }

    void e(String tag,String msg) {
        if (IS_TESTER) Log.e(tag, msg);
    }
}
