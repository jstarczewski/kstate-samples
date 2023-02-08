package com.jstarczewski.obtainable

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform