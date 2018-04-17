package com.melayer.fragments



import android.graphics.Color
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
            //(activity as MainActivity).loadFrag(MouseFragment())

            (activity as MainActivity).loadFrag(SimpleFragment.create(Color.RED))
        }
        rtVw.findViewById<Button>(R.id.btnScreen).setOnClickListener {
//            (activity as MainActivity).loadFrag(ScreenFragment())
            (activity as MainActivity).loadFrag(SimpleFragment.create(Color.GRAY))
        }
        rtVw.findViewById<Button>(R.id.btnMic).setOnClickListener {
//            (activity as MainActivity).loadFrag(MicFragment())
            (activity as MainActivity).loadFrag(SimpleFragment.create(Color.BLUE))
        }
        return rtVw
    }
}
