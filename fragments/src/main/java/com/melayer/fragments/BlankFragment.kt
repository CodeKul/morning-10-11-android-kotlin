package com.melayer.fragments



import android.os.Bundle
//import android.app.Fragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rtVw = inflater.inflate(R.layout.fragment_blank, container, false)
        rtVw.findViewById<Button>(R.id.btnMouse).setOnClickListener {
            (activity as MainActivity).loadFrag(MouseFragment())
        }
        rtVw.findViewById<Button>(R.id.btnScreen).setOnClickListener {
            (activity as MainActivity).loadFrag(ScreenFragment())
        }
        rtVw.findViewById<Button>(R.id.btnMic).setOnClickListener {
            (activity as MainActivity).loadFrag(MicFragment())
        }
        return rtVw
    }
}
