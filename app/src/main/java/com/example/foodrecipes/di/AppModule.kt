package com.example.foodrecipes.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.foodrecipes.data.remote.RecipeApi
import com.example.foodrecipes.data.repository.LocalUserRepositoryImpl
import com.example.foodrecipes.data.repository.RecipeRepositoryImpl
import com.example.foodrecipes.domain.repository.LocalUserRepository
import com.example.foodrecipes.domain.repository.RecipeRepository
import com.example.foodrecipes.domain.usecase.GetAppEntryUseCase
import com.example.foodrecipes.domain.usecase.GetRecipeUseCase
import com.example.foodrecipes.domain.usecase.SaveAppEntryUseCase
import com.example.foodrecipes.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePreferencesDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { appContext.preferencesDataStoreFile(Constants.USER_SETTINGS) }
        )
    }

    @Provides
    @Singleton
    fun provideLocalUserRepository(
        dataStore: DataStore<Preferences>
    ): LocalUserRepository = LocalUserRepositoryImpl(dataStore)

    @Provides
    @Singleton
    fun provideGetAppEntryUseCase(localUserRepository: LocalUserRepository): GetAppEntryUseCase =
        GetAppEntryUseCase(localUserRepository)

    @Provides
    @Singleton
    fun provideSaveAppEntryUseCase(localUserRepository: LocalUserRepository): SaveAppEntryUseCase =
        SaveAppEntryUseCase(localUserRepository)

    @Provides
    @Singleton
    fun provideRecipeApi() : RecipeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(recipeApi:RecipeApi) : RecipeRepository = RecipeRepositoryImpl(recipeApi)

    @Provides
    @Singleton
    fun provideGetRecipeUseCase(recipeRepository: RecipeRepository) : GetRecipeUseCase = GetRecipeUseCase(recipeRepository)


}