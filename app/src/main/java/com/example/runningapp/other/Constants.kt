package com.example.runningapp.other

import android.graphics.Color

object Constants {
    // Database
    const val RUNNING_DATABASE_NAME = "running_db"
    const val REQUEST_CODE_LOCATION_PERMISSION = 0

    //Tracking Service location tracking start, pause, stop
    const val ACTION_START_OR_RESUME_SERVICE = "ACTION_START_OR_RESUME_SERVICE"
    const val ACTION_PAUSE_SERVICE = "ACTION_PAUSE_SERVICE"
    const val ACTION_STOP_SERVICE = "ACTION_STOP_SERVICE"
    const val ACTION_SHOW_TRACKING_FRAGMENT = "ACTION_SHOW_TRACKING_FRAGMENT"

    // Location request for Tracking Service
    const val LOCATION_UPDATE_INTERVAL = 5000L
    const val FASTEST_LOCATION_INTERVAL = 2000L

    //Tracking Fragment Defining properties of polyline
    const val POLYLINE_COLOR = Color.RED
    const val POLYLINE_WIDTH = 8f

    //Tracking Fragment Map zoom camera animate
    const val MAP_ZOOM = 15f

    //Tracking Service updating the timer
    const val TIMER_UPDATE_INTERVAL=50L

    // Creating notification in
    const val NOTIFICATION_CHANNEL_ID = "tracking_channel"
    const val NOTIFICATION_CHANNEL_NAME = "Tracking"
    const val NOTIFICATION_ID = 1

    //Shared Preferences
    const val SHARED_PREFERENCES_NAME = "sharedPref"
    const val KEY_FIRST_TIME_TOGGLE = "KEY_FIRST_TIME_TOGGLE"
    const val KEY_NAME = "KEY_NAME"
    const val KEY_WEIGHT = "KEY_WEIGHT"


}