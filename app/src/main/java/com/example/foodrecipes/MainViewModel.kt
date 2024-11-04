package com.example.foodrecipes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipes.domain.usecase.GetAppEntryUseCase
import com.example.foodrecipes.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getAppEntryUseCase: GetAppEntryUseCase) :
    ViewModel() {

    var splashCondition by mutableStateOf(true)

    var startDestination by mutableStateOf(Route.OnBoardingScreen.route)

    fun getAppEntry() {
        getAppEntryUseCase.invoke().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen) {
                startDestination = Route.HomeScreen.route
            } else {
                startDestination = Route.OnBoardingScreen.route
            }
            delay(200)
            splashCondition = false
        }.launchIn(viewModelScope)
    }

}