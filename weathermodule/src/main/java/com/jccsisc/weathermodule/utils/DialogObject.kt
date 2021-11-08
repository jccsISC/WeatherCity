package com.jccsisc.weathermodule.utils

import android.app.Activity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.jccsisc.weathermodule.R
import com.jccsisc.weathermodule.databinding.WDialogGenericBinding

object DialogObject {

    fun showDialog(context: Activity, message: String) {

        val dialogView = context?.layoutInflater?.inflate(R.layout.w_dialog_generic, null, false)
        val dialog =
            MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme).setView(dialogView)
                .show()

        val bindingDialog = WDialogGenericBinding.bind(dialogView!!)

        bindingDialog.apply {
            txtDialogMessage.text = message
            btnDialog.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}