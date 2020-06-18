package me.jdvp.androidaspectexample.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.jdvp.androidaspectexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //The button ClickListener's below only have actions that create Toasts.
        //However, when you press the buttons at runtime, you will notice in LogCat
        //that messages are being logged as well. Those messages are being logged by
        //the Logger class as specified by aspects put in the AspectLogging file. The code
        //to do the logging is injected in-line at compile time

        //Not a lambda on purpose for demonstration purposes
        @Suppress("ObjectLiteralToLambda")
        button_1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "Button 1 clicked", Toast.LENGTH_SHORT).show()
            }
        })

        button_2.setOnClickListener { Toast.makeText(this@MainActivity, "Button 2 clicked", Toast.LENGTH_SHORT).show() }
    }
}