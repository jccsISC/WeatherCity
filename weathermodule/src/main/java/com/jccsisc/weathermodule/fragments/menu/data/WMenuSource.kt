package com.jccsisc.weathermodule.fragments.menu.data

import androidx.lifecycle.Observer
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.fragments.menu.model.response.city.WMCityResponse

interface WMenuSource {
    fun getDataCity(idCity: String, requestModel: RequestModel<Void>, observer: Observer<GenericResponse<WMCityResponse, String, RequestModel<Void>>>)
}