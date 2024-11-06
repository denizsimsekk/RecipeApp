package com.example.foodrecipes.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipes.common.ResponseState
import com.example.foodrecipes.data.model.Result
import com.example.foodrecipes.domain.usecase.SearchRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchRecipeUseCase: SearchRecipeUseCase)  :ViewModel(){

    private val _searchState= MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> =_searchState

    fun searchRecipe(query: String){
        viewModelScope.launch {
            searchRecipeUseCase.invoke(query).collect{
                _searchState.emit(_searchState.value.copy(recipes = it.data))
            }
        }
    }

    fun onEvent(searchEvent: SearchEvent){
        when(searchEvent){
            is SearchEvent.UpdateSearchQuery->{
                _searchState.value=_searchState.value.copy(searchQuery = searchEvent.query)
            }
            is SearchEvent.SearchRecipe->{
                searchRecipe(_searchState.value.searchQuery)
            }
        }
    }
}