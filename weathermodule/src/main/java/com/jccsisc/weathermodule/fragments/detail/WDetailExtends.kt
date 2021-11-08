package com.jccsisc.weathermodule.fragments.detail

import com.jccsisc.weathermodule.common.WEnumsTitles
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.fragments.menu.WMenuFragment
import com.jccsisc.weathermodule.utils.WLambdasObject
import com.jccsisc.weathermodule.utils.showToast

fun WDetailFragment.initElements() {
    mBinding.apply {
        WLambdasObject.changeTitle?.invoke(WEnumsTitles.DETAILS.title)

        viewModel.requestData(args.idCity, RequestModel())

    }
}

fun WDetailFragment.initObservers() {
    viewModel.responseGeneric.observe(viewLifecycleOwner, { data ->

        when (data.statusRequest) {

            StatusRequestEnum.LOADING -> showToast("Cargando...") //MOSTRAMOS EL LOTTIE
            StatusRequestEnum.SUCCESS -> {
                //OCULTAMOS EL LOTTIE

//                if (!viewModel.isOnBack.value!!) {
                data.successData?.let {
                    showToast("Se consumió correctamente")

                    mBinding.apply {
                        txtNameCity.text = it.name
                    }

                }
//                }

            }
            StatusRequestEnum.FAILURE -> {
                //ocultar lottie
                data.errorData?.let {
                    it
                    showToast(it)
                    //mostrar dialog del error

                    /*val dialog = CUBlurDialog(
                        cuTitleModel = CUTitleModel(it.errorResult, CUTitleType.WARNING),
                        buttonClicked = { dialogView -> dialogView.dismiss() },
                        buttonType = ButtonType(
                            CUButtonStyle = CUButtonStyle.NORMAL,
                            messageButton = getString(R.string.aceptar)
                        ),
                        cancelable = true
                    )
                    dialog.showCustom(requireActivity().supportFragmentManager, "dialog")*/
                }
            }
            StatusRequestEnum.NONE -> {
            }//OCULTAMOS LOTTIE
        }

    })
}