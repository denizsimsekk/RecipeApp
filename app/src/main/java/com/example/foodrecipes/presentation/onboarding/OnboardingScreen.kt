package com.example.foodrecipes.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.foodrecipes.presentation.onboarding.components.OnboardingPage


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen()
{
    Column(modifier = Modifier.fillMaxSize()) {

        val pagerState= rememberPagerState(initialPage = 0){
            onboardingPages.size
        }

        val buttonState= remember {
            derivedStateOf {
                when(pagerState.currentPage)
                {
                    1-> listOf("","Next")
                    2->listOf("Back","Next")
                    3->listOf("Back","Get Started")
                    else-> listOf()
                }
            }
        }

        HorizontalPager(pagerState) {index->
            OnboardingPage(onboardingPageItem = onboardingPages[index])
        }

    }


}