package com.jccsisc.weathermodule.fragments.detail

import com.jccsisc.weathermodule.common.WEnumsTitles
import com.jccsisc.weathermodule.utils.WLambdasObject

fun WDetailFragment.initElements() {
    mBinding.apply {
        WLambdasObject.changeTitle?.invoke(WEnumsTitles.DETAILS.title)


    }
}