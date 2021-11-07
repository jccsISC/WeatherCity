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

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        Thread.sleep(1500)
        goToActivity<MainActivity>()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }
}