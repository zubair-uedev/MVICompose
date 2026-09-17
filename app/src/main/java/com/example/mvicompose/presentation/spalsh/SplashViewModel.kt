package com.example.mvicompose.presentation.spalsh
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel() : ViewModel() {
    private val _events = MutableSharedFlow<SplashEvents>()
    val events = _events.asSharedFlow()

    fun onIntent(splashIntent: SplashIntent) {
        when (splashIntent) {
            SplashIntent.GoToOnBoard -> {
                viewModelScope.launch {
                    _events.emit(SplashEvents.NavigateToOnBoard)
                }
            }
        }
    }
}

sealed class SplashIntent {
    data object GoToOnBoard : SplashIntent()
}

sealed class SplashEvents {
    data object NavigateToOnBoard : SplashEvents()
}