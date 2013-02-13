/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.apps.dashclock.configuration;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Helper class for working with DashClock appearance settings.
 */
public class AppearanceConfig {
    static final String COMPONENT_TIME = "time";
    static final String COMPONENT_DATE = "date";

    static final String PREF_STYLE_TIME = "pref_style_time";
    static final String PREF_STYLE_DATE = "pref_style_date";

    static String[] TIME_STYLE_NAMES = new String[]{
            "default",
            "light",
            "alpha",
            "stock",
            "condensed",
            "big_small",
    };

    static String[] DATE_STYLE_NAMES = new String[]{
            "default",
            "simple",
            "condensed_bold"
    };

    public static int getCurrentTimeLayout(Context context) {
        String currentTimeStyleName = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_STYLE_TIME, TIME_STYLE_NAMES[0]);
        return getLayoutByStyleName(context, COMPONENT_TIME, currentTimeStyleName);
    }

    public static int getCurrentDateLayout(Context context) {
        String currentDateStyleName = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_STYLE_DATE, DATE_STYLE_NAMES[0]);
        return getLayoutByStyleName(context, COMPONENT_DATE, currentDateStyleName);
    }

    public static int getLayoutByStyleName(Context context, String component, String name) {
        return context.getResources().getIdentifier(
                "widget_include_" + component + "_style_" + name,
                "layout", context.getPackageName());
    }
}
