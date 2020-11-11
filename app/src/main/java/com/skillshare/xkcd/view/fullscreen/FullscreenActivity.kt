package com.skillshare.xkcd.view.fullscreen

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.skillshare.xkcd.R

class FullscreenActivity : AppCompatActivity() {
    private lateinit var fullscreenImage: ImageView
    private lateinit var titleView: TextView
    private lateinit var altTextView: TextView
    private lateinit var fullscreenOverlay: ViewGroup
    private lateinit var fullScreenHandler: FullScreenHandler
    private val viewModel = FullscreenViewModel()

    companion object {
        private const val EXTRA_COMIC_ID = "comic_id"
        @JvmStatic
        fun getLaunchIntent(context: Context, comicId: Int): Intent {
            val intent = Intent(context, FullscreenActivity::class.java)
            intent.putExtra(EXTRA_COMIC_ID, comicId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen)

        titleView = findViewById(R.id.fullscreen_title)
        altTextView = findViewById(R.id.fullscreen_alt_text)
        fullscreenImage = findViewById(R.id.fullscreen_image)
        fullscreenOverlay = findViewById(R.id.fullscreen_content_controls)
        fullScreenHandler = FullScreenHandler(fullscreenImage, fullscreenOverlay)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.title.observe(this, Observer { titleView.text = it })
        viewModel.altText.observe(this, Observer { altTextView.text = it })
        viewModel.url.observe(this, Observer {
            Glide.with(this).load(it).into(fullscreenImage)
        })
    }

    override fun onResume() {
        super.onResume()
        intent?.extras?.getInt(EXTRA_COMIC_ID)?.let {
            viewModel.attach(it)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        fullScreenHandler.hide()
    }
}