package com.jccsisc.weathermodule.fragments.menu.model

data class WMenuCityModel(
    val id: Int,
    val idCity: String,
    val image: String,
    val name: String,
    val country: String,
    val coord: WMenuLocation
    )

data class WMenuLocation(val lon: String, val lat: String)