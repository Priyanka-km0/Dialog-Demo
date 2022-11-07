package com.happiestminds.dailogdemo

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import java.security.KeyStore.TrustedCertificateEntry
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {
    lateinit var timeTextView : TextView
    lateinit var dateTextView:TextView

    lateinit var timeButton : Button
    lateinit var dateButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeTextView = findViewById(R.id.timeT)
        dateTextView = findViewById(R.id.dateT)

        timeButton = findViewById(R.id.timeB)
        dateButton = findViewById(R.id.dateB)

        timeTextView.text = " no time selected"
        dateTextView.text = " no date selected"
    }

    fun closeClick(view: View) {
        //get confirmation from user - user dialog
        //show dialog
        val dlg =  MyDialog()
        dlg.isCancelable = false

        val dataBundle = Bundle()
        dataBundle.putString("msg","Do you want to exit?")
        dlg.arguments = dataBundle
        dlg.show(supportFragmentManager,null)
    }

    override fun onBackPressed() {
        val dlg =  MyDialog()
        dlg.isCancelable = false

        val dataBundle = Bundle()
        dataBundle.putString("msg","confirm exit?")
        dlg.arguments = dataBundle
        dlg.show(supportFragmentManager,null)

    }

    fun selectTime(view: View) {
        // show time pickerDialog
        val dlg = TimePickerDialog(this, this,10, 0,true)

        dlg.show()

    }
    fun selectDate(view: View) {
        //date pickerDialog
        val dlg = DatePickerDialog(this)
        dlg.setOnDateSetListener{dPicker, year, month, day->
            dateTextView.text = "$day- ${month+1} - $year"
            dateButton.isEnabled = false
        }
        dlg.show()
    }

    override fun onTimeSet(tPicker: TimePicker?, hh: Int, mm: Int) {
        timeTextView.text = "$hh : $mm"

    }

    fun downloadClick(view: View) {
//        val dlg = ProgressDialog.show(this,"Downloading", "Please wait")
//
//        Timer().schedule(1000){
//            dlg.cancel()
//        }

         val  sBar = Snackbar.make(this, timeButton,
        "downloading...",Snackbar.LENGTH_INDEFINITE)
        sBar.setAction("Cancel"){
            sBar.dismiss()
        }
        sBar.show()
    }

}