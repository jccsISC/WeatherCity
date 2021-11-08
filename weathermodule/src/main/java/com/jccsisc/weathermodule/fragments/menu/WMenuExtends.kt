package com.jccsisc.weathermodule.fragments.menu

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.jccsisc.weathermodule.R
import com.jccsisc.weathermodule.common.WEnumsTitles
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.fragments.menu.adapter.WMenuAdapter
import com.jccsisc.weathermodule.fragments.menu.model.WMenuCityModel
import com.jccsisc.weathermodule.fragments.menu.model.WMenuLocation
import com.jccsisc.weathermodule.utils.WLambdasObject.changeTitle
import com.jccsisc.weathermodule.utils.showToast
import com.jccsisc.weathermodule.utils.showView

fun WMenuFragment.initElements() {
    mBinding.apply {

        changeTitle?.invoke(WEnumsTitles.LIST_CITIES.title)
        viewModel.requestData(RequestModel())

    }
}

fun WMenuFragment.initObservers() {
    viewModel.responseGeneric.observe(viewLifecycleOwner, { data ->

        when (data.statusRequest) {

            StatusRequestEnum.LOADING -> showToast("Cargando...") //MOSTRAMOS EL LOTTIE
            StatusRequestEnum.SUCCESS -> {
                //OCULTAMOS EL LOTTIE

                data.successData?.let {

                    mBinding.apply {
                        val adapter = WMenuAdapter()
                        rvCities.adapter = adapter
                        adapter.submitList(it)

                        Handler(Looper.getMainLooper()).postDelayed({
                            shimmerFrameLayout.stopShimmer()
                            shimmerFrameLayout.showView(false)
                            rvCities.showView(true)
                        }, 500)

                        adapter.onItemClickListener = {
                            if (isNetworkAvailable(requireContext())) {
                                val action = WMenuFragmentDirections.actionWMenuFragmentToWDetailFragment(it.idCity)
                                findNavController().navigate(action)
                            } else {
                                showToast("Revisa tu conexión de internet o datos móviles")
                            }

                        }
                    }
                }

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
            StatusRequestEnum.NONE -> { }//OCULTAMOS LOTTIE
        }

    })
}