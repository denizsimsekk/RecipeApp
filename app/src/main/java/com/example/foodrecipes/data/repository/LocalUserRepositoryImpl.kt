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

class LocalUserRepositoryImpl(private val dataStore: DataStore<Preferences>) : LocalUserRepository {
    override suspend fun saveAppEntry() {
        dataStore.edit { setting ->
            setting[Constants.PreferenceKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[Constants.PreferenceKeys.APP_ENTRY] ?: false

        }
    }
}



