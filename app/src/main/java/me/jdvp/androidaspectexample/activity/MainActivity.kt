package me.jdvp.androidaspectexample.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.jdvp.androidaspectexample.R

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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