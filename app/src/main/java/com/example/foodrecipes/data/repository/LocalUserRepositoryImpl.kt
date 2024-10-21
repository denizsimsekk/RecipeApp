package com.example.foodrecipes.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.foodrecipes.domain.repository.LocalUserRepository
import com.example.foodrecipes.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserRepositoryImpl(private val context: Context) : LocalUserRepository {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {setting->
            setting[PreferenceKeys.APP_ENTRY]=true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {preferences->
            preferences[PreferenceKeys.APP_ENTRY] ?: false

        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.USER_SETTINGS)

private object PreferenceKeys {
    val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
}
