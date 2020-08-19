package layout

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    val valRed = MutableLiveData<Int>()
    val valGreen = MutableLiveData<Int>()
    val valBlue = MutableLiveData<Int>()

    fun setAll(red : Int, green : Int, blue : Int){
        valRed.value = red
        valGreen.value = green
        valBlue.value = blue

    }
    fun setRed(red:Int){
        valRed.value = red
    }
    fun setGreen(green: Int){
        valGreen.value = green
    }
    fun setBlue(blue: Int){
        valBlue.value = blue
    }



}