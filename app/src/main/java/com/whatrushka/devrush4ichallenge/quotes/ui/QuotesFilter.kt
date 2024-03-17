package com.whatrushka.devrush4ichallenge.quotes.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.whatrushka.devrush4ichallenge.R
import com.whatrushka.devrush4ichallenge.quotes.data.QuotesViewModel
import com.whatrushka.devrush4ichallenge.storage.data.FilterService
import org.koin.compose.koinInject

@Composable
fun QuotesFilter(viewModel: QuotesViewModel, modifier: Modifier) {
    val showFilter = remember { mutableStateOf(false) }


    Icon(
        painter = painterResource(R.drawable.icon_filter),
        contentDescription = null,
        modifier = modifier
            .size(42.dp)
            .clickable {
                showFilter.value = true
                Log.d("m", "clicked sf ${showFilter.value}")
            }
    )

    QuotesFilterModal(viewModel, showFilter, modifier)
}

@Composable
fun QuotesFilterModal(viewModel: QuotesViewModel, expanded: MutableState<Boolean>, modifier: Modifier) {
    val scrollState = rememberScrollState()
    val close = { expanded.value = false }

    val setFilter: (String) -> Unit = { selectedCategory ->
        viewModel.configureFilter {
            it.category = selectedCategory
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        DropdownMenu(
            expanded = expanded.value,
            scrollState = scrollState,
            onDismissRequest = close,
            modifier = Modifier.fillMaxWidth()
        ) {
            viewModel.getCategories().forEach {
                DropdownMenuItem(
                    text = { Text(text = it) },
                    onClick = {
                        close()
                        setFilter(it)
                    },
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}