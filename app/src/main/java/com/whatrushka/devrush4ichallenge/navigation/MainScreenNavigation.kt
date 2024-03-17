package com.whatrushka.devrush4ichallenge.navigation

import androidx.compose.runtime.Composable import androidx.compose.ui.Modifier

import org.koin.compose.koinInject
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.whatrushka.devrush4ichallenge.quotes.routes.QuotesNavRoute

@Composable
fun MainScreenNavigation(modifier: Modifier) {
    val navController = rememberNavController()

    val quotesFeature: QuotesNavigation = koinInject()

    NavHost(
        navController = navController,
        startDestination = QuotesNavRoute.route
    ) {
        register(quotesFeature, navController, modifier)
    }
}