package com.jccsisc.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.jccsisc.weatherapp.databinding.ActivityMainBinding
import com.jccsisc.weathermodule.common.WEnumsTitles
import com.jccsisc.weathermodule.utils.WLambdasObject
import com.jccsisc.weathermodule.utils.showView

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {

            val down = AnimationUtils.loadAnimation(this@MainActivity, R.anim.down)

            txtTitle.animation = down

            btnBack.setOnClickListener { onBackPressed() }

            WLambdasObject.changeTitle = {
                txtTitle.text = it
                when(it) {
                    WEnumsTitles.LIST_CITIES.title -> btnBack.showView(false)
                    WEnumsTitles.DETAILS.title -> btnBack.showView(true)
                }
            }
        }
    }
}