package com.example.mvicompose.routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes : NavKey{
    @Serializable
    data object SplashRoute : Routes

    @Serializable
    data object OnBoardRoute : Routes

    @Serializable
    data object DashBoardRoute : Routes
}