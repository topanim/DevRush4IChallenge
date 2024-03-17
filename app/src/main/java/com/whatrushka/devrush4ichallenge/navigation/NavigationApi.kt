package com.whatrushka.devrush4ichallenge.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.whatrushka.navigation.routes.Routes


interface NavigationApi {
    val route: Routes

    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    )
}