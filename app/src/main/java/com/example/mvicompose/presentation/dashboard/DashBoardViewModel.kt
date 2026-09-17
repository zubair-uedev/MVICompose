package com.example.mvicompose.presentation.dashboard
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class DashBoardViewModel() : ViewModel() {
    private val _dashBoardEvent = MutableSharedFlow<DashBoardEvent>()
    val dashBoardEvent = _dashBoardEvent.asSharedFlow()
    fun onIntent(dashBoardIntent: DashBoardIntent) {
        when (dashBoardIntent) {
            DashBoardIntent.NavigateToDetail -> {
                viewModelScope.launch {
                    _dashBoardEvent.emit(DashBoardEvent.NavigateDetailEvent)
                }
            }
        }
    }
}

sealed class DashBoardIntent {
    data object NavigateToDetail : DashBoardIntent()
}

sealed class DashBoardEvent {
    data object NavigateDetailEvent : DashBoardEvent()
}
