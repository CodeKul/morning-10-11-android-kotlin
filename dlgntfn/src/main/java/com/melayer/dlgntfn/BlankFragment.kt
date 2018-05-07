package com.melayer.dlgntfn


import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        when (tag) {
            "alert" -> {
                return AlertDialog.Builder(activity as Context)
                        .setTitle("Title")
                        .setMessage("Message")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton(
                                "Okay",
                                { _, _ -> Log.i("@codekul", "Okay") }
                        )
                        .setNegativeButton(
                                "Cancel",
                                { _, _ -> Log.i("@codekul", "Cancel") }
                        ).create()
            }
            "date" -> return DatePickerDialog(activity, { _, year, month, dayOfMonth ->
                    Log.i("@codekul", " $dayOfMonth - ${month + 1} - $year ")
                }, 2018, 4, 7)
            "time" -> return TimePickerDialog(
                    activity,
                    { _, hourOfDay, minute -> Log.i("@codekul", " $hourOfDay:$minute ")  },
                    10,
                    59,
                    false
            )
        }
        return  AlertDialog.Builder(activity as Context)
                .setView(R.layout.my_dialog)
                .setTitle("Progress Title")
                .setMessage("Progress Message")
                .setIcon(R.mipmap.ic_launcher)
                .create()
    }

}// Required empty public constructor
