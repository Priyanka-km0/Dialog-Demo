package com.happiestminds.dailogdemo

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

//created kotlin class MyDialog
class MyDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var dlg: Dialog? = null// nullable
        //retrieve bundle
         val message = arguments?.getString("msg")
        //create dialog here
        context.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("confirmation")
            builder.setMessage(message)
            builder.setPositiveButton("YES") { dialog, i ->
                //executed button clicking
                activity?.finish()
            }
            builder.setNegativeButton("NO") { dialog, i ->
                //executed button clicking
                dialog.cancel()
            }
            builder.setNeutralButton("CANCEL") { dialog, i ->
                //executed button clicking
                dialog.cancel()
            }
            dlg = builder.create()
        }
        return dlg!!

    }
}