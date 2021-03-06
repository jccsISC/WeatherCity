package com.jccsisc.weathermodule.fragments.detail

import com.bumptech.glide.Glide
import com.jccsisc.weathermodule.R
import com.jccsisc.weathermodule.common.WEnumsTitles
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.utils.DialogObject
import com.jccsisc.weathermodule.utils.WLambdasObject
import com.jccsisc.weathermodule.utils.showView

fun WDetailFragment.initElements() {
    mBinding.apply {

        WLambdasObject.changeTitle?.invoke(WEnumsTitles.DETAILS.title)
        viewModel.requestData(args.idCity, RequestModel())

    }
}

fun WDetailFragment.initObservers() {
    mBinding.apply {
        viewModel.responseGeneric.observe(viewLifecycleOwner, { data ->

            when (data.statusRequest) {

                StatusRequestEnum.LOADING -> animationView.showView(true)
                StatusRequestEnum.SUCCESS -> {
                    animationView.showView(false)

                    data.successData?.let {
                        Glide.with(this@initObservers)
                            .load(args.image)
                            .centerCrop()
                            .into(imgCity)

                        txtNameCity.text = it.name
                        txtTemp.text = it.main.temp.toString()

                        for (i in it.weather) {
                            txtWeather.text = getString(R.string.weather, i.main)
                            txtDescription.text = getString(R.string.description, i.description)

                            when(i.icon) {
                                "01d" -> {
                                    imgWeather.setImageResource(R.drawable.one)
                                }
                                "03d" -> {
                                    imgWeather.setImageResource(R.drawable.three)
                                }
                                "04d" -> {
                                    imgWeather.setImageResource(R.drawable.four)
                                }
                            }
                        }
                    }
                }
                StatusRequestEnum.FAILURE -> {
                    animationView.showView(false)
                    data.errorData?.let {
                        DialogObject.showDialog(requireActivity(), it)
                    }
                }
                StatusRequestEnum.NONE -> { }
            }
        })
    }
}