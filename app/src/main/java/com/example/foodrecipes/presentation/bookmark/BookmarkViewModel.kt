package com.example.foodrecipes.presentation.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.domain.usecase.DeleteRecipeUseCase
import com.example.foodrecipes.domain.usecase.GetFavoriteRecipesUseCase
import com.example.foodrecipes.domain.usecase.InsertRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(private val getFavoriteRecipesUseCase: GetFavoriteRecipesUseCase) :
    ViewModel() {

    private val _recipes = MutableStateFlow<List<Recipe>>(listOf())
    val recipe: StateFlow<List<Recipe>> = _recipes

    init {
        getFavoriteRecipes()
    }

    fun getFavoriteRecipes() {
        viewModelScope.launch {
            getFavoriteRecipesUseCase.invoke().collect { response ->
                _recipes.emit(response)
            }
        }
    }

}