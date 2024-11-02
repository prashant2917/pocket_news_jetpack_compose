package com.app.pocketnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.pocketnews.ui.theme.PocketNewsTheme
import com.app.pocketnews.widgets.AppBar
import com.app.pocketnews.widgets.AppNavHost
import com.app.pocketnews.widgets.AppRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketNewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    val navController: NavHostController = rememberNavController()
                    val backStackEntry by navController.currentBackStackEntryAsState()
                    // Get the name of the current screen
                    val currentScreen = backStackEntry?.destination?.route
                    val isBackStackEntryPresent = currentScreen != AppRoute.TopHeadlines.route


                    Scaffold(
                        topBar = {
                            AppBar(
                                canNavigateBack = isBackStackEntryPresent,
                                navigateUp = { navController.navigateUp() }
                            )
                        }
                    ) { innerPadding ->
                        AppNavHost(
                            navController = navController,
                            innerPadding = innerPadding
                        )

                    }
                }
            }
        }
    }
}
