package com.example.mvicompose.navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mvicompose.presentation.dashboard.DashBoard
import com.example.mvicompose.presentation.detaildata.DetailData
import com.example.mvicompose.presentation.onboard.OnBoardEvent
import com.example.mvicompose.presentation.onboard.OnBoardScreen
import com.example.mvicompose.presentation.onboard.OnBoardViewModel
import com.example.mvicompose.presentation.spalsh.SplashEvents
import com.example.mvicompose.presentation.spalsh.SplashScreen
import com.example.mvicompose.presentation.spalsh.SplashViewModel
import com.example.mvicompose.routes.Routes

@Composable
fun Navigation() {
    val backStack = rememberNavBackStack(Routes.SplashRoute)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.SplashRoute> {
                val splashViewModel: SplashViewModel = viewModel()
                LaunchedEffect(Unit) {
                    splashViewModel.events.collect { events ->
                        when (events) {
                            SplashEvents.NavigateToOnBoard -> {
                                backStack.add(
                                    Routes.OnBoardRoute
                                )
                            }
                        }
                    }
                }
                SplashScreen(onIntent = splashViewModel::onIntent)
            }
            entry<Routes.OnBoardRoute> {
                val onBoardViewModel: OnBoardViewModel= viewModel()
                LaunchedEffect(Unit) {
                    onBoardViewModel.onBoardEvent.collect { event ->
                        when (event) {
                            OnBoardEvent.onBoardEvent -> {
                                backStack.add(
                                    Routes.DashBoardRoute
                                )
                            }
                        }
                    }
                }
                OnBoardScreen(
                    onIntent = onBoardViewModel::onIntent,
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