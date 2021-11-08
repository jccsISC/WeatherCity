package com.jccsisc.weathermodule.fragments.detail.model.response.city

import com.jccsisc.weathermodule.fragments.detail.model.response.city.Clouds
import com.jccsisc.weathermodule.fragments.detail.model.response.city.Coord
import com.jccsisc.weathermodule.fragments.detail.model.response.city.Main
import com.jccsisc.weathermodule.fragments.detail.model.response.city.Sys
import com.jccsisc.weathermodule.fragments.detail.model.response.city.Weather
import com.jccsisc.weathermodule.fragments.detail.model.response.city.Wind

data class WDetailsCityResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)