package com.example.foodrecipes.utils

import androidx.datastore.preferences.core.booleanPreferencesKey

object Constants {
    const val USER_SETTINGS="user_settings"
    const val APP_ENTRY="app_entry"
    object PreferenceKeys {
        val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
    }
    const val BASE_URL="https://api.spoonacular.com/"
}