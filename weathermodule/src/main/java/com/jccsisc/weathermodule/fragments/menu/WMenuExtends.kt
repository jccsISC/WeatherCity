package com.jccsisc.weathermodule.fragments.menu

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.jccsisc.weathermodule.R
import com.jccsisc.weathermodule.common.WEnumsTitles
import com.jccsisc.weathermodule.common.core.request.RequestModel
import com.jccsisc.weathermodule.common.core.status.StatusRequestEnum
import com.jccsisc.weathermodule.databinding.WDialogGenericBinding
import com.jccsisc.weathermodule.fragments.menu.adapter.WMenuAdapter
import com.jccsisc.weathermodule.utils.DialogObject.showDialog
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
    mBinding.apply {
        viewModel.responseGeneric.observe(viewLifecycleOwner, { data ->

            when (data.statusRequest) {
                StatusRequestEnum.LOADING -> { }
                StatusRequestEnum.SUCCESS -> {
                    Handler(Looper.getMainLooper()).postDelayed({
                        shimmerFrameLayout.stopShimmer()
                        shimmerFrameLayout.showView(false)
                        rvCities.showView(true)
                    }, 200)

                    data.successData?.let { it ->
                        val adapter = WMenuAdapter()
                        rvCities.adapter = adapter
                        adapter.submitList(it)

                        adapter.onItemClickListener = {
                            if (isNetworkAvailable(requireContext())) {
                                val action = WMenuFragmentDirections.actionWMenuFragmentToWDetailFragment(
                                    it.idCity,
                                    it.image
                                    )
                                findNavController().navigate(action)
                            } else {
                                showDialog(requireActivity(), getString(R.string.erro_conection))
                            }
                        }
                    }
                }
                StatusRequestEnum.FAILURE -> {
                    data.errorData?.let {
                        showDialog(requireActivity(), it)
                    }
                }
                StatusRequestEnum.NONE -> { }
            }
        })
    }
}