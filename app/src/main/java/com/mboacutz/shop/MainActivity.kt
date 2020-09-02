package com.mboacutz.shop

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import android.webkit.WebViewClient
import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.webView

class MainActivity : AppCompatActivity() {
    private var backPressedTime = 0L

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init web view
        webView.webViewClient = WebViewClient()
        // Set web view settings
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.safeBrowsingEnabled = true
        // Load url
        webView.loadUrl("https://www.preview.mboacutz.com/")
    }

    // Handle back button pressed
    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            // Navigate to previous page if browser history exist
            webView.goBack()
        } else {
            if(backPressedTime + 2000 > System.currentTimeMillis()) {
                // Can exit if there is 2 seconds between the back button double tap
                super.onBackPressed()
            } else {
                // Neither toast call to action message
                Toast.makeText(
                        applicationContext,
                        "Appuiyez à nouveau pour quitter",
                        Toast.LENGTH_SHORT
                ).show()
            }
            // Update user back pressed time
        }
    }
}