package com.csab.daggermvpstarter;

import android.content.Context;

import net.danlew.android.joda.DateUtils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;

public class Utils {

    // TODO: determine optimal approach. Context dependency is problematic for junit testing
    public static String formatSerializedDate(Context context, String serializedDate) {
        DateTime dt = DateTime.parse(serializedDate);
        ReadableInstant ri = dt.toDateTime(DateTimeZone.getDefault());
        return DateUtils.formatDateTime(context, ri,
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_TIME);
    }
}
