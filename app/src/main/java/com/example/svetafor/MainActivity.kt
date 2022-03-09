package com.example.svetafor

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    var imSvetafor: ImageView? = null
    var imageArray: IntArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)
    var counter = 0
    var timer: Timer? = null
    var isRun = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imSvetafor = findViewById(R.id.imSvetafor)
    }

    fun onclickStartStop(view: View) {
            view as ImageButton
        if (!isRun) {
            startStop()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
        } else {
            imSvetafor?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            isRun = true
            counter = 0
        }
    }

    fun startStop() {
        timer = Timer()

        timer?.schedule(object : TimerTask(){
            override fun run() {
                imSvetafor?.setImageResource(imageArray[counter])
                counter++
                if (counter == 3) counter = 0
            }
        }, 0,3000)
    }
}


