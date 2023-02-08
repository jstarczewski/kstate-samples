package com.jstarczewski.saveable

import com.jstarczewski.kstate.StateHolder
import com.jstarczewski.kstate.Stateful

expect fun <T : Any> StateHolder.saveableState(initialValue: T): Stateful<T>

fun <T : Any> T.update(update: T.(T) -> T) = this.update(this)
