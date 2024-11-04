package com.example.foodrecipes.presentation.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.domain.usecase.GetRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getRecipeUseCase: GetRecipeUseCase):ViewModel() {

    private val _recipes= MutableStateFlow<ResponseState<List<Recipe>>>(ResponseState.Empty())
    val recipe : StateFlow<ResponseState<List<Recipe>>> =_recipes

    init {
        getRecipes()
    }
    fun getRecipes(){
        viewModelScope.launch {
            getRecipeUseCase.invoke().collect{response->
                _recipes.emit(response)
            }
        }
    }


}