package com.whatrushka.devrush4ichallenge.quotes.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.whatrushka.devrush4ichallenge.quotes.data.QuotesViewModel
import com.whatrushka.devrush4ichallenge.storage.data.FilterService
import com.whatrushka.devrush4ichallenge.storage.models.Filter
import org.koin.compose.koinInject
import org.koin.java.KoinJavaComponent.inject

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuotesScreen(
    viewModel: QuotesViewModel,
    navController: NavController,
    modifier: Modifier
) {
    val quotes = viewModel.quotes()
    val pagerState = rememberPagerState(0, 0f) { quotes.value.size }

    LaunchedEffect(Unit) {
        viewModel.fetchQuotes()
    }

    LaunchedEffect(pagerState.currentPage) {
        Log.d("m", "curp ${pagerState.currentPage}")
        if (quotes.value.size - pagerState.currentPage == 3)
            viewModel.fetchQuotes()
    }

    Box(modifier) {

        QuotesFilter(
            viewModel = viewModel,
            modifier = Modifier.zIndex(2f)
        )

        VerticalPager(pagerState, key = { it }) {
            QuoteItem(quotes.value[it])
        }
    }
}