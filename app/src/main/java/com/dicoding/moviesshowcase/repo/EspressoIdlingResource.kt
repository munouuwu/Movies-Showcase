package com.dicoding.moviesshowcase.repo

import androidx.test.espresso.IdlingResource
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