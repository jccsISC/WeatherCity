package com.jccsisc.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.jccsisc.weathermodule.utils.goToActivity
import kotlinx.coroutines.delay

class ScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        goToActivity<MainActivity>()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }
}