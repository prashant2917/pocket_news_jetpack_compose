package com.app.pocketnews.widgets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.pocketnews.topheadlines.ui.TopHeadlinesScreen
import com.app.pocketnews.utils.PocketNewsConstants

@Composable
fun AppNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.TopHeadlines.route,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        composable(route = AppRoute.TopHeadlines.route) {
            TopHeadlinesScreen()
        }

    }
}


sealed class AppRoute(val route: String) {
    data object TopHeadlines : AppRoute(PocketNewsConstants.AppRouteConstants.ROUTE_TOP_HEADLINES)
    data object ProductDetails : AppRoute("detail_screen")
    data object Profile : AppRoute("profile")

    fun withArgs(args: String): String {
        return buildString {
            append("$route/")
            args.forEach { arg ->
                append(arg)
            }
        }
    }
}