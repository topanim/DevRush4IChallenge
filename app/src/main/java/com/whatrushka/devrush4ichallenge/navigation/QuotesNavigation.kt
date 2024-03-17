package com.whatrushka.devrush4ichallenge.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.whatrushka.devrush4ichallenge.quotes.routes.QuotesNavRoute
import com.whatrushka.devrush4ichallenge.quotes.data.QuotesViewModel
import com.whatrushka.devrush4ichallenge.quotes.ui.QuotesScreen
import com.whatrushka.navigation.routes.Routes
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class QuotesNavigation : NavigationApi, KoinComponent {
    override val route: Routes = QuotesNavRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route.route) {
            val viewModel: QuotesViewModel by inject()
            QuotesScreen(viewModel, navController, modifier)
        }
    }
}