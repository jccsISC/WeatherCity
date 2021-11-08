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
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {

            val up = AnimationUtils.loadAnimation(this@MainActivity, R.anim.up)
            val down = AnimationUtils.loadAnimation(this@MainActivity, R.anim.down)
            val left = AnimationUtils.loadAnimation(this@MainActivity, R.anim.slide_in_left)
            val right = AnimationUtils.loadAnimation(this@MainActivity, R.anim.slide_in_right)

            txtTitle.animation = down

            btnBack.setOnClickListener { onBackPressed() }

            WLambdasObject.changeTitle = {
                txtTitle.text = it
                when(it) {
                    WEnumsTitles.LIST_CITIES.title -> btnBack.showView(false)
                    WEnumsTitles.DETAILS.title -> btnBack.showView(true)
                }
            }


            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHostFragment.findNavController()

            navController.addOnDestinationChangedListener { _, destination, _ ->

                when(destination.id) {
                    R.id.WMenuFragment -> {
                        txtTitle.animation = right
                    }
                    R.id.WDetailFragment -> {
                        txtTitle.animation = left
                    }
                }
            }
        }
    }
}