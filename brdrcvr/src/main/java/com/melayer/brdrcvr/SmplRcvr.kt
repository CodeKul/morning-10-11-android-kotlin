package com.melayer.brdrcvr

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by aniruddha on 4/5/18.
 */
class SmplRcvr : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("@codekul", "SmplRcvr")
    }
}