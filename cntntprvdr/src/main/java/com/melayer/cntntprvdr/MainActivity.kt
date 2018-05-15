package com.melayer.cntntprvdr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dt = arrayListOf<String>()

        val proj = arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER
        )
        val sel = null
        val slArg = null
        val srtOr = null
        val crsr = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                proj,
                sel,
                slArg,
                srtOr
        )

        while(crsr.moveToNext()) {
            val nm = crsr.getString(
                    crsr.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                    )
            )

            val num = crsr.getString(
                    crsr.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                    )
            )
            dt.add("$nm \n $num")
        }

        listView.adapter = ArrayAdapter<String>(
                this@MainActivity,
                android.R.layout.simple_list_item_1,
                dt
        )
        crsr.close()
    }
}
