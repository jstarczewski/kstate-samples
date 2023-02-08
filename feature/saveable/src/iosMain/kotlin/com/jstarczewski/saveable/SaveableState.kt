package com.jstarczewski.saveable

import com.jstarczewski.kstate.Stateful

actual class SaveableState<T : Any>(
    initialValue: T,
) : Stateful<T>(initialValue, {})