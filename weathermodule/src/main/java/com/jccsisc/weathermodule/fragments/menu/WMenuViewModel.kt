package com.jccsisc.weathermodule.fragments.menu

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.jccsisc.weathermodule.common.core.request.GenericRequest
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.fragments.menu.data.WMenuRemoteRepository
import com.jccsisc.weathermodule.fragments.menu.model.response.city.WMCityResponse

class WMenuViewModel: ViewModel() {

    private val repository = WMenuRemoteRepository()

    val responseGeneric: GenericRequest<GenericResponse<WMCityResponse, String, RequestModel<Void>>> = GenericRequest()


    fun requestData(idCity: String, requestModel: RequestModel<Void>) {
        responseGeneric.postValue(GenericResponse(StatusRequestEnum.LOADING, requestData = requestModel))
        repository.getDataCity(idCity, requestModel, observeDataResponse())
    }

    private fun observeDataResponse() = Observer<GenericResponse<WMCityResponse, String, RequestModel<Void>>> {
        responseGeneric.postValue(it)
    }
}