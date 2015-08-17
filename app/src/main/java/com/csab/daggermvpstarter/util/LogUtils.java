package com.csab.daggermvpstarter.util;

public class LogUtils {

    private LogUtils() {
    }

    public static String generateTag(Object object) {
        return object.getClass().getCanonicalName();
    }
}