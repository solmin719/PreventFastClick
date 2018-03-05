package com.solmin.preventfastclick

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Normal Button
        normalBtn.setOnClickListener {
            changeBgColorRandomly(it)
        }

        // FastClick Prevented Button
        fastClickPreventedBtn.setOnClickListener(object : PreventFastClickOnClickListener() {
            override fun onClicked(view: View) {
                changeBgColorRandomly(view)
            }
        })
    }

    private fun changeBgColorRandomly(view: View) {
        val color = Color.rgb(Random().nextInt(255), Random().nextInt(255), Random().nextInt(255))
        view.setBackgroundColor(color)
    }
}
