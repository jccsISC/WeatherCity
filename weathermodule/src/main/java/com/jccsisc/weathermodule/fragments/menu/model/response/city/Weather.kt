package com.jccsisc.weathermodule.fragments.menu.model.response.city

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)