package com.jccsisc.weathermodule.fragments.detail

import androidx.lifecycle.ViewModel
import com.jccsisc.weathermodule.common.core.request.GenericRequest
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.fragments.detail.data.WDetailsRemoteRepository
import com.jccsisc.weathermodule.fragments.detail.model.response.city.WDetailsCityResponse

class WDetailsViewModel: ViewModel() {

    private val repository = WDetailsRemoteRepository()

    val responseGeneric: GenericRequest<GenericResponse<WDetailsCityResponse, String, RequestModel<Void>>> = GenericRequest()

    fun requestData(idCity: String, requestModel: RequestModel<Void>) {
        responseGeneric.postValue(GenericResponse(StatusRequestEnum.LOADING, requestData = requestModel))
        repository.getDataCity(idCity, requestModel) {
            responseGeneric.postValue(it)
        }
    }
}