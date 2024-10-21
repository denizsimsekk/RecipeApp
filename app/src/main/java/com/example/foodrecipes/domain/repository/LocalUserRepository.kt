package com.example.foodrecipes.domain.repository

import kotlinx.coroutines.flow.Flow

interface LocalUserRepository {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}