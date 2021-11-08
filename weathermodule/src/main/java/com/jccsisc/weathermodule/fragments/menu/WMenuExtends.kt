package com.jccsisc.weathermodule.fragments.menu

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.jccsisc.weathermodule.R
import com.jccsisc.weathermodule.common.WEnumsTitles
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.fragments.menu.adapter.WMenuAdapter
import com.jccsisc.weathermodule.fragments.menu.model.CityModel
import com.jccsisc.weathermodule.utils.WLambdasObject.changeTitle
import com.jccsisc.weathermodule.utils.showToast
import com.jccsisc.weathermodule.utils.showView

fun WMenuFragment.initElements() {
    mBinding.apply {

        changeTitle?.invoke(WEnumsTitles.LIST_CITIES.title)

        val listCities = mutableListOf<CityModel>()
        listCities.add(CityModel(1, "3527646","https://ichef.bbci.co.uk/news/800/cpsprodpb/16D7C/production/_102946539_gettyimages-909755746.jpg", "Ciudad de México"))
        listCities.add(CityModel(2, "3995402","https://oasishoteles.com/blog/wp-content/uploads/2021/04/catedral.jpg", "Morelia"))
        listCities.add(CityModel(3,"4018400","https://i.pinimg.com/564x/1f/65/ef/1f65efd6601f06f87f3b52379b7b8e17.jpg", "Apatzingán Michoacán"))
        listCities.add(CityModel(4, "3527646","https://ichef.bbci.co.uk/news/800/cpsprodpb/16D7C/production/_102946539_gettyimages-909755746.jpg", "Ciudad de México"))
        listCities.add(CityModel(5, "3527646","https://ichef.bbci.co.uk/news/800/cpsprodpb/16D7C/production/_102946539_gettyimages-909755746.jpg", "Ciudad de México"))

        val adapter = WMenuAdapter()
        rvCities.adapter = adapter
        adapter.submitList(listCities)

        Handler(Looper.getMainLooper()).postDelayed({
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.showView(false)
            rvCities.showView(true)
        }, 500)

        adapter.onItemClickListener = {
            if (isNetworkAvailable(requireContext())) {
//                viewModel.requestData(it.cityId, RequestModel())
                findNavController().navigate(R.id.action_WMenuFragment_to_WDetailFragment)
            } else {
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
            StatusRequestEnum.NONE -> {
            }//OCULTAMOS LOTTIE
        }

    })
}