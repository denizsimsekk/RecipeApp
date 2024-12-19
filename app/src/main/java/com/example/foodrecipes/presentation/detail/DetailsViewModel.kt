package com.example.foodrecipes.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.local.RecipeDao
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.domain.usecase.DeleteRecipeUseCase
import com.example.foodrecipes.domain.usecase.GetRecipeFromRoomUseCase
import com.example.foodrecipes.domain.usecase.GetRecipeUseCase
import com.example.foodrecipes.domain.usecase.InsertRecipeUseCase
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getRecipeFromRoomUseCase: GetRecipeFromRoomUseCase,
    private val insertRecipeUseCase: InsertRecipeUseCase,
    private val deleteRecipeUseCase: DeleteRecipeUseCase,
    private val getRecipeUseCase: GetRecipeUseCase
) : ViewModel() {

    private val _isSaved= MutableStateFlow<Boolean>(false)
    val isSaved : StateFlow<Boolean> =_isSaved
    private val _recipe= MutableStateFlow<ResponseState<Recipe>>(ResponseState.Empty())
    val recipe : StateFlow<ResponseState<Recipe>> =_recipe

    fun onEvent(recipe: Recipe) {
        viewModelScope.launch {
            val recipeFromRoom = getRecipeFromRoomUseCase.invoke(recipe.sourceUrl ?: "")
            if (recipeFromRoom == null) {
                insertRecipeUseCase.invoke(recipe)
                _isSaved.value=true

            } else {
                deleteRecipeUseCase.invoke(recipe)
                _isSaved.value=false
            }
        }

    }

    fun getRecipe(jsonString: String?, id: Int?) {
        viewModelScope.launch {
            if (!jsonString.isNullOrEmpty()) {
                val recipe = Gson().fromJson(jsonString, Recipe::class.java)
                _recipe.value = ResponseState.Success(recipe)
                val recipeFromRoom = getRecipeFromRoomUseCase.invoke(recipe?.sourceUrl ?: "")
                _isSaved.value=recipeFromRoom!=null
            }else if (id != null) {
                getRecipeUseCase.invoke(id).collect {
                    _recipe.value=it
                }
            }
        }
    }

   /* private fun getRecipe(jsonString: String?, id: Int?) {
        viewModelScope.launch {
            if (!jsonString.isNullOrEmpty()) {
                // Parse the JSON string
                val recipe = Gson().fromJson(jsonString, Recipe::class.java)
                _recipe.value = ResponseState.Success(recipe)
            } else if (id != null) {
                getRecipeUseCase.invoke(id).collect {
                    _recipe.value=it
                }
            }
        }
    }*/


}