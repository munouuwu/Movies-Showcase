package com.dicoding.moviesshowcase.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private val RESOURCE: String? = "GLOBAL"
    val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }
    fun decrement() {
        espressoTestIdlingResource.decrement()
    }
}