package com.skillshare.xkcd.view.fullscreen

import android.annotation.SuppressLint
import android.os.Handler
import android.view.View
import androidx.lifecycle.LifecycleObserver

/**
 *
 *
 *!!!!! NOTE: YOU CAN MOSTLY IGNORE THIS CLASS !!!!!!
 *
 *
 * This class exists to encapsulate the hiding/showing of fullscreen view elements
 */
class FullScreenHandler(
    private val fullscreenContentView: View,
    private val overlayView: View
) : LifecycleObserver {

    companion object {
        private const val UI_ANIMATION_DELAY = 300L
    }

    private val hideHandler = Handler()
    private var isFullscreen: Boolean = false

    @SuppressLint("InlinedApi")
    private val hidePart2Runnable = Runnable {
        // Delayed removal of status and navigation bar

        // Note that some of these constants are new as of API 16 (Jelly Bean)x
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        fullscreenContentView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }
    private val showPart2Runnable = Runnable {
        // Delayed display of UI elements
        overlayView.visibility = View.VISIBLE
    }

    init {
        fullscreenContentView.setOnClickListener { toggle() }

    }

    private fun toggle() {
        if (isFullscreen) {
            hide()
        } else {
            show()
        }
    }


    fun hide() {
        // Hide UI first
        overlayView.visibility = View.GONE
        isFullscreen = false

        // Schedule a runnable to remove the status and navigation bar after a delay
        hideHandler.removeCallbacks(showPart2Runnable)
        hideHandler.postDelayed(hidePart2Runnable, UI_ANIMATION_DELAY)
    }

    fun show() {
        // Show the system bar
        fullscreenContentView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        isFullscreen = true

        // Schedule a runnable to display UI elements after a delay
        hideHandler.removeCallbacks(hidePart2Runnable)
        hideHandler.postDelayed(showPart2Runnable, UI_ANIMATION_DELAY)
    }
}