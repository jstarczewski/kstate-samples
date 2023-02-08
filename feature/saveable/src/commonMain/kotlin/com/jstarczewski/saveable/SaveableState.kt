package com.jstarczewski.saveable

import com.jstarczewski.kstate.Stateful

expect class SaveableState<T : Any> : Stateful<T>