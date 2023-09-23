package com.ashutoshwahane.modernandroid.util

import android.content.Context
import android.content.res.Configuration

fun Context.darkModeEnabled(): Boolean =
    (resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) == Configuration.UI_MODE_NIGHT_YES
