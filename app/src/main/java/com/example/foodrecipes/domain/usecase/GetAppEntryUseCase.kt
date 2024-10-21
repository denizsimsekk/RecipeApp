package com.example.foodrecipes.domain.usecase

import com.example.foodrecipes.domain.repository.LocalUserRepository
import kotlinx.coroutines.flow.Flow

class GetAppEntryUseCase(private val localUserRepository: LocalUserRepository) {

    operator fun invoke(): Flow<Boolean> {
        return localUserRepository.readAppEntry()
    }
}