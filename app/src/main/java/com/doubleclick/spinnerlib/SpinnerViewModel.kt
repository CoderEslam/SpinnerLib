package com.doubleclick.spinnerlib

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SpinnerViewModel : ViewModel() {

    private val _spinnerState = MutableStateFlow(SpinnerState())
    val spinnerState = _spinnerState.asStateFlow()


    fun onEvent(event: SpinnerEvent) {
        when (event) {
            is SpinnerEvent.Choose -> {
                _spinnerState.update { it.copy(s = event.s) }
            }
        }
    }

    fun t(){
        _spinnerState.value.s.age
    }

}

sealed interface SpinnerEvent {
    data class Choose(val s: Eslam) : SpinnerEvent
}

data class SpinnerState(
    val s: Eslam = Eslam("", 0)
)