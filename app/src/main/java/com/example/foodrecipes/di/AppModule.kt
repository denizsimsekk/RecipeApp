package com.example.foodrecipes.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.foodrecipes.data.local.RecipeDao
import com.example.foodrecipes.data.local.RecipeDatabase
import com.example.foodrecipes.data.local.TypeConvertor
import com.example.foodrecipes.data.remote.RecipeApi
import com.example.foodrecipes.data.repository.LocalUserRepositoryImpl
import com.example.foodrecipes.data.repository.RecipeRepositoryImpl
import com.example.foodrecipes.domain.repository.LocalUserRepository
import com.example.foodrecipes.domain.repository.RecipeRepository
import com.example.foodrecipes.domain.usecase.DeleteRecipeUseCase
import com.example.foodrecipes.domain.usecase.GetAppEntryUseCase
import com.example.foodrecipes.domain.usecase.GetFavoriteRecipesUseCase
import com.example.foodrecipes.domain.usecase.GetRecipeUseCase
import com.example.foodrecipes.domain.usecase.InsertRecipeUseCase
import com.example.foodrecipes.domain.usecase.SaveAppEntryUseCase
import com.example.foodrecipes.domain.usecase.SearchRecipeUseCase
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


    @Provides
    @Singleton
    fun provideSearchRecipeUseCase(recipeRepository: RecipeRepository) : SearchRecipeUseCase = SearchRecipeUseCase(recipeRepository)

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): RecipeDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = RecipeDatabase::class.java,
            name = "recipe_db"
        ).addTypeConverter(TypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideRecipeDao(
        recipeDatabase: RecipeDatabase
    ): RecipeDao = recipeDatabase.recipeDao

    @Provides
    @Singleton
    fun provideInsertRecipeUseCase(dao:RecipeDao) : InsertRecipeUseCase = InsertRecipeUseCase(dao)


    @Provides
    @Singleton
    fun provideDeleteRecipeUseCase(dao:RecipeDao) : DeleteRecipeUseCase = DeleteRecipeUseCase(dao)


    @Provides
    @Singleton
    fun provideGetFavoriteRecipesUseCase(dao:RecipeDao) : GetFavoriteRecipesUseCase = GetFavoriteRecipesUseCase(dao)


}