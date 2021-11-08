package com.jccsisc.weathermodule.fragments.menu.data

import androidx.lifecycle.Observer
import com.jccsisc.weathermodule.BuildConfig
import com.jccsisc.weathermodule.common.WMEnumsURL
import com.jccsisc.weathermodule.common.core.InitServices
import com.jccsisc.weathermodule.common.core.ValidResponse
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.response.GenericResponse
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.fragments.detail.data.WDetailsSource
import com.jccsisc.weathermodule.fragments.detail.model.response.city.WDetailsCityResponse
import com.jccsisc.weathermodule.fragments.menu.model.WMenuCityModel
import com.jccsisc.weathermodule.fragments.menu.model.WMenuLocation
import retrofit2.Call

class WMenuLocalRepository : WMenuSource {

    override fun getListCities(
        requestModel: RequestModel<Void>,
        observer: Observer<GenericResponse<List<WMenuCityModel>, String, RequestModel<Void>>>
    ) {

        val listCities = mutableListOf<WMenuCityModel>()
        listCities.add(WMenuCityModel(1, "3527646","https://ichef.bbci.co.uk/news/800/cpsprodpb/16D7C/production/_102946539_gettyimages-909755746.jpg", "Ciudad de México","MX", WMenuLocation("-99.166672", "19.25")))
        listCities.add(WMenuCityModel(2, "3995402","https://oasishoteles.com/blog/wp-content/uploads/2021/04/catedral.jpg", "Morelia", "CO", WMenuLocation("-75.725807", "1.48747")))
        listCities.add(WMenuCityModel(3,"4018400","https://i.pinimg.com/564x/1f/65/ef/1f65efd6601f06f87f3b52379b7b8e17.jpg", "Apatzingán Michoacán", "MX", WMenuLocation( "-102.349998", "19.08333")))
        listCities.add(WMenuCityModel(4, "3980760","https://scontent.fmex38-1.fna.fbcdn.net/v/t1.18169-9/22893954_1636432723062508_740806523858160162_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=e3f864&_nc_eui2=AeGTw7tyPnA7Rc_PUosTMBVtLVmI9zyZDiItWYj3PJkOIlKWWa0D7c3k-BS3bohu2pV5R9Qkd3WVR-bb_mbes_2R&_nc_ohc=VF-dJYDn8rkAX85VqyA&_nc_ht=scontent.fmex38-1.fna&oh=f83531349de26dea21a21eaac4be3bfa&oe=61AFDE35", "Uruapan",  "MX", WMenuLocation( "-102.066673", "19.41667")))
        listCities.add(WMenuCityModel(5, "3991328","https://www.eleconomista.com.mx/__export/1608503112180/sites/eleconomista/img/2020/12/06/puerto_vallarta_shutterstoc.jpg_1093282975.jpg", "PuertoVallarta",  "MX", WMenuLocation("-105.230659", "20.620411")))


        observer.onChanged(
            GenericResponse(
                StatusRequestEnum.SUCCESS,
                listCities,
                errorData = null,
                requestModel
            )
        )
    }
}