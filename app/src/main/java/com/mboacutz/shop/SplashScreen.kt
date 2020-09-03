package com.mboacutz.shop

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.logo

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        logo.alpha = 1f
        val mainActivityIntent = Intent(this, MainActivity::class.java);
        // Wait 1500 ms
        logo.animate().setDuration(1500).alpha(1f).withEndAction {
            // Start app & close splash screen with transition
            startActivity(mainActivityIntent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}