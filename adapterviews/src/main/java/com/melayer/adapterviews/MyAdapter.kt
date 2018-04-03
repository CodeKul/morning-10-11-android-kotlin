package com.melayer.adapterviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by aniruddha on 3/4/18.
 */

data class MyItem(
        val img: Int,
        val txt: String
)

class MyAdapter(
        private val context: Context,
        private val rawData: ArrayList<MyItem>
) : BaseAdapter() {

    private val inflater: LayoutInflater by lazy {
        LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val vw = inflater.inflate(
                R.layout.my_item,
                parent,
                false
        )

        vw.findViewById<ImageView>(R.id.imgVw).setImageResource(rawData[position].img)
        vw.findViewById<TextView>(R.id.txtVw).text = rawData[position].txt

        return vw
    }

    override fun getItem(position: Int): Any = rawData[position]

    override fun getItemId(position: Int): Long = (position * 9).toLong()

    override fun getCount(): Int = rawData.size
}