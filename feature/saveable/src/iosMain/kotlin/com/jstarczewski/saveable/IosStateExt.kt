package com.jstarczewski.saveable

import com.jstarczewski.kstate.Stateful
import com.jstarczewski.kstate.StateHolder

actual fun <T : Any> StateHolder.saveableState(initialValue: T): Stateful<T> =
    Stateful(initialValue) { binder.objectWillChange() }
