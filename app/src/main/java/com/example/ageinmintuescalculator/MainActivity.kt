package com.example.ageinmintuescalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            OnClickListner()
        }
    }

    private fun OnClickListner() {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
           this ,  DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month+1}/$year"
                selected.text = selectedDate
                val sdf = SimpleDateFormat("dd/mm/yyyy" , Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                val dateInMin = theDate.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val curDateInMin = currentDate.time / 60000
                val diff = curDateInMin - dateInMin
                resault.text = diff.toString()
            },
            year , month , day
        ).show()

    }
}