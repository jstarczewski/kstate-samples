package com.jstarczewski.saveable

import kotlinx.coroutines.CoroutineScope

expect abstract class KmmViewModel constructor() {

    val viewModelScope: CoroutineScope

    open fun onClear()
}