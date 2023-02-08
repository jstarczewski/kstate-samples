package com.jstarczewski.saveable

import androidx.lifecycle.SavedStateHandle.Companion.validateValue
import com.jstarczewski.kstate.StateHolder
import com.jstarczewski.kstate.Stateful

actual fun <T : Any> StateHolder.saveableState(initialValue: T): Stateful<T> {
    require(this is CanPersistState) {
        "Cannot save state from something which does not conform to `CanPersistState` interface"
    }
    return if (validateValue(initialValue)) {
        com.jstarczewski.saveable.SaveableState(
            initialValue = initialValue,
            holderKey = key(),
            getSavedValue = { key -> savedStateHandle[key] },
            saveValue = { key, value -> savedStateHandle[key] = value }
        )
    } else {
        throw IllegalArgumentException(
            "Cannot persist state of value which cannot be store in Parcel"
        )
    }
}

private fun StateHolder.key() = this::class.java.simpleName
