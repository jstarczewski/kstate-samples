package com.jstarczewski.saveable

import androidx.lifecycle.SavedStateHandle

interface CanPersistState {

    var savedStateHandle: SavedStateHandle
}
