package com.jccsisc.weathermodule.fragments.menu.data

import androidx.lifecycle.Observer
import com.jccsisc.weathermodule.BuildConfig
import com.jccsisc.weathermodule.common.WMEnumsURL
import com.jccsisc.weathermodule.common.core.InitServices
import com.jccsisc.weathermodule.common.core.ValidResponse
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.fragments.menu.model.response.city.WMCityResponse
import retrofit2.Call

class WMenuRemoteRepository: WMenuSource {

    override fun getDataCity(idCity: String, requestModel: RequestModel<Void>, observer: Observer<GenericResponse<WMCityResponse, String, RequestModel<Void>>>) {

        val initService: InitServices<Void, Call<WMCityResponse>> = InitServices(BuildConfig.BASE_URL)

        ValidResponse(observer, requestModel, WMCityResponse::class).validationMethod(initService.getExecuteServiceCity(WMEnumsURL.PATH.url, idCity, WMEnumsURL.API_KEY.url))
    }

}