package com.example.kotlinStructure.util

import android.view.View
import com.airbnb.lottie.LottieAnimationView
import javax.inject.Inject

class ViewHelper @Inject constructor() {

    fun hideLoader(loader: LottieAnimationView) {
        loader.visibility = View.GONE
    }

    fun showLoader(loader: LottieAnimationView) {
        loader.visibility = View.VISIBLE
        loader.showContextMenu()
    }
}