package com.melayer.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class SimpleFragment() : Fragment() {

    companion object {
        fun create(col : Int) : SimpleFragment {

            val bndl = Bundle()
            bndl.putInt("keyColor", col)

            val frag = SimpleFragment()
            frag.arguments = bndl

            return frag
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val rtVw = inflater.inflate(R.layout.fragment_simple, container, false)
        rtVw.setBackgroundColor(arguments.getInt("keyColor"))

        return rtVw
    }

}// Required empty public constructor
