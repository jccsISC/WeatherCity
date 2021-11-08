package com.jccsisc.weathermodule.fragments.detail.data

import androidx.lifecycle.Observer
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.fragments.detail.model.response.city.WDetailsCityResponse

interface WDetailsSource {
    fun getDataCity(
        idCity: String,
        requestModel: RequestModel<Void>,
        observer: Observer<GenericResponse<WDetailsCityResponse, String, RequestModel<Void>>>
    )
}