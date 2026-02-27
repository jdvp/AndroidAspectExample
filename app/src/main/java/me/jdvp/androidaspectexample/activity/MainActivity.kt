package me.jdvp.androidaspectexample.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import me.jdvp.androidaspectexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Using findViewById so we don't have to worry about deprecations later
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)

        //The button ClickListener's below only have actions that create Toasts.
        //However, when you press the buttons at runtime, you will notice in LogCat
        //that messages are being logged as well. Those messages are being logged by
        //the Logger class as specified by aspects put in the AspectLogging file. The code
        //to do the logging is injected in-line at compile time

        //Not a lambda on purpose for demonstration purposes
        @Suppress("ObjectLiteralToLambda")
        button1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                AlertDialog.Builder(this@MainActivity)
                    .setMessage("Button 1 clicked")
                    .show()
            }
        })

        button2.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setMessage("Button 2 clicked")
                .show()
        }
    }
}