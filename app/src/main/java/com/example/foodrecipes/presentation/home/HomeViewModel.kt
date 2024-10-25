package com.example.foodrecipes.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Recipe
import com.example.foodrecipes.domain.usecase.GetRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getRecipeUseCase: GetRecipeUseCase):ViewModel() {

    private val _recipes=MutableLiveData<ResponseState<List<Recipe>>>()
    val recipe :LiveData<ResponseState<List<Recipe>>>
        get()=_recipes

    fun getRecipes(){
        viewModelScope.launch {
            getRecipeUseCase.invoke().collect{response->
                when(response){
                    is ResponseState.Loading->{
                        _recipes.postValue(response)
                    }
                    is ResponseState.Success->{
                        _recipes.postValue(response)
                    }
                    is ResponseState.Error->{
                        _recipes.postValue(response)

                    }
                }

            }
        }
    }


}