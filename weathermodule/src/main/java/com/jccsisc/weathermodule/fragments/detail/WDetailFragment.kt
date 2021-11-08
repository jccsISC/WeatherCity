package com.jccsisc.weathermodule.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jccsisc.weathermodule.R
import com.jccsisc.weathermodule.databinding.WDetailFragmentBinding
import com.jccsisc.weathermodule.fragments.menu.WMenuViewModel

class WDetailFragment : Fragment(R.layout.w_detail_fragment) {

    lateinit var mBinding: WDetailFragmentBinding
    val viewModel: WDetailsViewModel by viewModels()
    val args: WDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding = WDetailFragmentBinding.bind(view)
        super.onViewCreated(mBinding.root, savedInstanceState)

        initObservers()
        initElements()
    }
}