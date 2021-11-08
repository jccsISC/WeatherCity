package com.jccsisc.weathermodule.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.jccsisc.weathermodule.R
import com.jccsisc.weathermodule.databinding.WDetailFragmentBinding

class WDetailFragment : Fragment(R.layout.w_detail_fragment) {

    lateinit var mBinding: WDetailFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding = WDetailFragmentBinding.bind(view)
        super.onViewCreated(mBinding.root, savedInstanceState)

        initElements()
    }
}