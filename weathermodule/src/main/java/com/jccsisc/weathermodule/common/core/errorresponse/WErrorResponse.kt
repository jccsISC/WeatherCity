package com.jccsisc.weathermodule.common.core.errorresponse

data class WErrorResponse(
    val code: Int? = null,
    val headersRequest: String? = null,
    val bodyRequest: String? = null,
    val errorBody: WErrorResponseGeneric? = null,
    val errorResult: String? = null
)