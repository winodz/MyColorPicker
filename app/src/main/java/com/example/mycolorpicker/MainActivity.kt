package com.example.mycolorpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment()
        //loadDispFragment()
    }

    private fun loadDispFragment() {

        supportFragmentManager.beginTransaction().replace(R.id.fragment_display,DisplayFragment()).commit()
    }

    fun loadFragment() {


        supportFragmentManager.beginTransaction().replace(R.id.frameBar,ColorBarFragment()).commit()
    }

    fun emitColorChange(red: Int, green : Int, blue : Int){

        val displayFragment = supportFragmentManager.findFragmentById(R.id.fragment_display) as DisplayFragment
        //displayFragment.setNewColor()
    }

}