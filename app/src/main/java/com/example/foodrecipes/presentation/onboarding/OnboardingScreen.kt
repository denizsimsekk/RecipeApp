package com.example.foodrecipes.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.foodrecipes.R
import com.example.foodrecipes.presentation.common.CommonButton
import com.example.foodrecipes.presentation.common.CommonTextButton
import com.example.foodrecipes.presentation.onboarding.components.OnboardingPage
import com.example.foodrecipes.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.light_pink))
    ) {

        val pagerState = rememberPagerState(initialPage = 0) {
            onboardingPages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf()
                }
            }
        }

        HorizontalPager(pagerState) { index ->
            OnboardingPage(onboardingPageItem = onboardingPages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            PageIndicator(
                modifier = Modifier.padding(2.dp),
                pageSize = onboardingPages.size,
                selectedPage = pagerState.currentPage
            )
            Row()
            {
                val scope= rememberCoroutineScope()
                if(buttonState.value[0].isNotEmpty())
                {
                    CommonTextButton(buttonState.value[0]) {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage-1)
                        }
                    }
                }
                CommonButton(buttonState.value[1]) {
                    if(pagerState.currentPage==3)
                    {
                        //TODO navigate
                    }
                    else{
                        scope.launch {

                            pagerState.animateScrollToPage(page = pagerState.currentPage+1)
                        }
                    }

                }
            }
        }

    }


}