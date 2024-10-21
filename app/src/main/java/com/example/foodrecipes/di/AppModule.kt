package com.example.foodrecipes.di

import android.app.Application
import com.example.foodrecipes.data.repository.LocalUserRepositoryImpl
import com.example.foodrecipes.domain.repository.LocalUserRepository
import com.example.foodrecipes.domain.usecase.GetAppEntryUseCase
import com.example.foodrecipes.domain.usecase.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserRepository(application:Application):LocalUserRepository=LocalUserRepositoryImpl(application)

    @Provides
    @Singleton
    fun provideGetAppEntryUseCase(localUserRepository: LocalUserRepository):GetAppEntryUseCase=
        GetAppEntryUseCase(localUserRepository)

    @Provides
    @Singleton
    fun provideSaveAppEntryUseCase(localUserRepository: LocalUserRepository):SaveAppEntryUseCase=
        SaveAppEntryUseCase(localUserRepository)
}