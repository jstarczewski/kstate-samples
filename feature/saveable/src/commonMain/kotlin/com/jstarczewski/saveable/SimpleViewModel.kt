package com.jstarczewski.saveable

import com.jstarczewski.kstate.StateHolder
import com.jstarczewski.kstate.stateful
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SimpleViewModel : KmmViewModel(), StateHolder by StateHolder() {

    var message by stateful("Hello World")
        private set

    var isLoading by stateful(false)
        private set

    fun updateMessage() = viewModelScope.launch {
        isLoading = true
        delay(500)
        message = "Hello kstate"
        isLoading = false
    }
}