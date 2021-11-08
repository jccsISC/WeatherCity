package com.jccsisc.weathermodule.common.core.errorresponse

data class WErrorResponseGeneric(
    val codigo: String,
    val mensaje: String,
    val folio: String,
    val info: String,
    var detalles: ArrayList<WErrorResponseModel>
)