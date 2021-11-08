package com.jccsisc.weathermodule.fragments.menu.model

data class CityModel(
    val id: Int,
    val idCity: String,
    val image: String,
    val name: String,
    val state: String,
    val country: String,
    val coord: WMenuLocation
    )

data class Location(val lon: String, val lat: String)