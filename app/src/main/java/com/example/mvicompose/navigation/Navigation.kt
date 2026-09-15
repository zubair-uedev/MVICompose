package com.example.mvicompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.mvicompose.presentation.dashboard.DashBoard
import com.example.mvicompose.presentation.onboard.OnBoardScreen
import com.example.mvicompose.presentation.spalsh.SplashScreen
import com.example.mvicompose.routes.Routes

@Composable
fun Navigation() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Routes.SplashRoute) {
//        composable<Routes.SplashRoute> {
//            SplashScreen(goToSplash = {
//                navController.navigate(Routes.OnBoardRoute)
//            })
//        }
//        composable<Routes.OnBoardRoute> {
//            OnBoardScreen(goToOnBoard = {
//                navController.navigate(Routes.DashBoardRoute)
//            })
//        }
//        composable<Routes.DashBoardRoute> {
//            DashBoard()
//        }
//    }
    val backStack = remember { mutableStateListOf<Routes>(Routes.SplashRoute) }
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.SplashRoute> {
                SplashScreen(
                    goToSplash = {
                        backStack.add(
                            Routes.OnBoardRoute
                        )
                    }
                )
            }
            entry<Routes.OnBoardRoute> {
                OnBoardScreen(
                    goToOnBoard = {
                        backStack.add(
                            Routes.DashBoardRoute
                        )
                    }
                )
            }
            entry<Routes.DashBoardRoute> {
                DashBoard()
            }
        }
    )
}