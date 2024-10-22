package com.example.foodrecipes.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipes.domain.usecase.SaveAppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val useCase:SaveAppEntryUseCase) : ViewModel() {

    fun saveAppEntry()
    {
        viewModelScope.launch {
            useCase.invoke()
        }

    }
}