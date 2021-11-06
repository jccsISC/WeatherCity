package com.jccsisc.weathermodule.common.core.request

data class RequestModel<B>(
    val requestBody: B? = null,
    var requestUrl: String? = null,
    var requestHeaders: HashMap<String, String>? = null
)