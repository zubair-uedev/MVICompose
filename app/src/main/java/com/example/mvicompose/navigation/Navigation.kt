package com.example.mvicompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mvicompose.presentation.dashboard.DashBoard
import com.example.mvicompose.presentation.detaildata.DetailData
import com.example.mvicompose.presentation.onboard.OnBoardScreen
import com.example.mvicompose.presentation.spalsh.SplashScreen
import com.example.mvicompose.routes.Routes

@Composable
fun Navigation() {
    val backStack = rememberNavBackStack(Routes.SplashRoute)
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
                    goToDashBoard = {
                        backStack.removeAll(backStack)
                        backStack.add(
                            Routes.DashBoardRoute
                        )
                    }
                )
            }
            entry<Routes.DashBoardRoute> {
                DashBoard()
            }
            entry<Routes.DataDetailRoute> {
                DetailData()
            }
        }
    )
}