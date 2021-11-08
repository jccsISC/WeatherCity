package com.jccsisc.weathermodule.fragments.menu.data

import androidx.lifecycle.Observer
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.fragments.detail.model.response.city.WDetailsCityResponse
import com.jccsisc.weathermodule.fragments.menu.model.WMenuCityModel

interface WMenuSource {
    fun getListCities(requestModel: RequestModel<Void>, observer: Observer<GenericResponse<List<WMenuCityModel>, String, RequestModel<Void>>>)
}