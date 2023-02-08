package com.jstarczewski.saveable

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

private val androidx.lifecycle.ViewModel.scope
    get() = this.viewModelScope

actual abstract class KmmViewModel actual constructor() :
    androidx.lifecycle.ViewModel() {

    final override fun onCleared() {
        onClear()
        super.onCleared()
    }

    actual open fun onClear() = Unit

    actual val viewModelScope: CoroutineScope
        get() = scope
}