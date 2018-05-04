package com.melayer.srvc

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {

    private var mp: MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            mp = MediaPlayer.create(this@MyService, R.raw.my)
            mp?.start()
        }.start()
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onDestroy() {
        mp?.stop()
        mp?.release()
        super.onDestroy()
    }
}
