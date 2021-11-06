package com.jccsisc.weathermodule.common.core

import com.jccsisc.weathermodule.common.core.request.RestEngine

class InitServices<M, R>(baseUrl: String? = null ) {
    var userService: GenericService = RestEngine.getRestEngine(baseUrl).create(GenericService::class.java)
    fun getExecuteServiceCity(endPoint: String, id: String, appid: String) = userService.serviceResponseGetNoBody(endPoint, id, appid) as R

}