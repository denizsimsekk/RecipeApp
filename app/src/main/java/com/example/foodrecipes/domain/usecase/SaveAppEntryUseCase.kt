package com.example.foodrecipes.domain.usecase

import com.example.foodrecipes.domain.repository.LocalUserRepository

class SaveAppEntryUseCase(private val localUserRepository: LocalUserRepository) {

    suspend operator fun invoke(){
        localUserRepository.saveAppEntry()
    }
}