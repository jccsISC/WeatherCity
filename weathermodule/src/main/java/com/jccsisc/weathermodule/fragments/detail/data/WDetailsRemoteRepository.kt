package com.jccsisc.weathermodule.fragments.detail.data

import androidx.lifecycle.Observer
import com.jccsisc.weathermodule.BuildConfig
import com.jccsisc.weathermodule.common.WMEnumsURL
import com.jccsisc.weathermodule.common.core.InitServices
import com.jccsisc.weathermodule.common.core.ValidResponse
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.fragments.detail.model.response.city.WDetailsCityResponse
import retrofit2.Call

class WDetailsRemoteRepository : WDetailsSource {

    override fun getDataCity(
        idCity: String,
        requestModel: RequestModel<Void>,
        observer: Observer<GenericResponse<WDetailsCityResponse, String, RequestModel<Void>>>
    ) {

        val initService: InitServices<Void, Call<WDetailsCityResponse>> =
            InitServices(BuildConfig.BASE_URL)

        ValidResponse(
            observer,
            requestModel,
            WDetailsCityResponse::class
        ).validationMethod(
            initService.getExecuteServiceCity(
                WMEnumsURL.PATH.url,
                idCity,
                WMEnumsURL.API_KEY.url
            )
        )
    }

}