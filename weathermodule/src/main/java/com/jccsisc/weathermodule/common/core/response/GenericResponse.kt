package com.jccsisc.weathermodule.common.core.response

import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum

data class GenericResponse<S, E, Any>(val statusRequest: StatusRequestEnum = StatusRequestEnum.NONE,
                                      val successData: S? = null,
                                      val errorData: E? = null,
                                      val requestData: Any)