package com.jccsisc.weathermodule.fragments.menu

import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.utils.showToast

fun WMenuFragment.initElements() {
    mBinding.apply {

        btnGet.setOnClickListener {
            if (isNetworkAvailable(requireContext())) {
                viewModel.requestData("4018400", RequestModel())
            }else {
                showToast("Revisa tu conexión de internet o datos móviles")
            }
        }

    }
}

fun WMenuFragment.initObservers() {
    viewModel.responseGeneric.observe(viewLifecycleOwner, { data ->

        when (data.statusRequest) {

            StatusRequestEnum.LOADING -> showToast("Cargando...") //MOSTRAMOS EL LOTTIE
            StatusRequestEnum.SUCCESS -> {
               //OCULTAMOS EL LOTTIE

//                if (!viewModel.isOnBack.value!!) {
                    data.successData?.let {
                        showToast("Se consumió correctamente")
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
            StatusRequestEnum.NONE -> {}//OCULTAMOS LOTTIE
        }

    })
}