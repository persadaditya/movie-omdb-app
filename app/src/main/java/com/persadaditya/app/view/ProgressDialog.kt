package com.persadaditya.app.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.persadaditya.app.R

class ProgressDialog {

    companion object{
        @SuppressLint("InflateParams")
        fun progressDialog(context: Context): Dialog{
            val dialog = Dialog(context)
            val inflate = LayoutInflater.from(context).inflate(R.layout.item_progress, null)
            dialog.setContentView(inflate)
            dialog.setCancelable(false)
            dialog.window!!.setBackgroundDrawable(
                ColorDrawable(Color.TRANSPARENT)
            )
            return dialog
        }
    }
}