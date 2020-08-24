package com.example.mycolorpicker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private val _valRed = MutableLiveData<Int>()
    val valRed : LiveData<Int>
    get() = _valRed

    private val _valGreen = MutableLiveData<Int>()
    val valGreen : LiveData<Int>
    get() = _valGreen

    private val _valBlue = MutableLiveData<Int>()
    val valBlue : LiveData<Int>
    get() = _valBlue




    init {
        _valRed.value = 0
        _valGreen.value = 255
        _valBlue.value = 255

    }
    fun setAll(red : Int, green : Int, blue : Int){
        _valRed.value = red
        _valGreen.value = green
        _valBlue.value = blue

    }
    fun setRed(red:Int){
        _valRed.value = red
    }
    fun setGreen(green: Int){
        _valGreen.value = green
    }
    fun setBlue(blue: Int){
        _valBlue.value = blue
    }


    fun getHexColorCode(): String{

        return "Hex Color code"
    }
    fun getRGBColorCode(): String{

        return "RGB Color code"
    }

}