package com.jccsisc.weathermodule.fragments.menu

import androidx.lifecycle.ViewModel
import com.jccsisc.weathermodule.common.core.request.GenericRequest
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.fragments.detail.data.WDetailsRemoteRepository
import com.jccsisc.weathermodule.fragments.detail.model.response.city.WDetailsCityResponse
import com.jccsisc.weathermodule.fragments.menu.data.WMenuLocalRepository
import com.jccsisc.weathermodule.fragments.menu.model.WMenuCityModel

class WMenuViewModel: ViewModel() {

    private val repository = WMenuLocalRepository()

    val responseGeneric: GenericRequest<GenericResponse<List<WMenuCityModel>, String, RequestModel<Void>>> = GenericRequest()

    fun requestData(requestModel: RequestModel<Void>) {
        responseGeneric.postValue(GenericResponse(StatusRequestEnum.LOADING, requestData = requestModel))
        repository.getListCities(requestModel) {
            responseGeneric.postValue(it)
        }
    }
}