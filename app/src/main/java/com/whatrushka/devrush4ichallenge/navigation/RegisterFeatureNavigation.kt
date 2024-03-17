package com.whatrushka.devrush4ichallenge.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.whatrushka.devrush4ichallenge.navigation.NavigationApi

fun NavGraphBuilder.register(
    feature: NavigationApi,
    navController: NavHostController,
    modifier: Modifier
) {
    feature.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}