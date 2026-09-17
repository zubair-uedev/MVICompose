package com.example.mvicompose.presentation.onboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class OnBoardViewModel() : ViewModel() {
    private val _onBoardEvent = MutableSharedFlow<OnBoardEvent>()
    val onBoardEvent = _onBoardEvent.asSharedFlow()

    fun onIntent(onBoardingIntent: OnBoardingIntent) {
        when (onBoardingIntent) {
            OnBoardingIntent.GoToDashBoard -> {
                viewModelScope.launch {
                    _onBoardEvent.emit(OnBoardEvent.onBoardEvent)
                }
            }

        }
    }

}

sealed class OnBoardingIntent {
    data object GoToDashBoard : OnBoardingIntent()
}

sealed class OnBoardEvent {
    data object onBoardEvent : OnBoardEvent()
}