package com.example.mycolorpicker

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycolorpicker.databinding.FragmentDisplayBinding


/**
 * A simple [Fragment] subclass.
 * Use the [DisplayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private lateinit var binding : FragmentDisplayBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_display,container,false)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


       //binding = FragmentDisplayBinding.inflate(inflater,container,false)

        //return inflater.inflate(R.layout.fragment_display, container, false)
        binding.viewModel = viewModel

        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        viewModel.valRed.observe(viewLifecycleOwner, Observer<Int> {item ->

            setNewColor(
                viewModel.valRed.value!!,
                viewModel.valGreen.value!!,
                viewModel.valBlue.value!!
            )


            //binding.frameDisplay.background
        })
        //setNewColor(255,255,30)
        viewModel.valGreen.observe(viewLifecycleOwner, Observer<Int> {item ->

            setNewColor(
                viewModel.valRed.value!!,
                viewModel.valGreen.value!!,
                viewModel.valBlue.value!!
            )


            //binding.frameDisplay.background
        })
        viewModel.valBlue.observe(viewLifecycleOwner, Observer<Int> {item ->

            setNewColor(
                viewModel.valRed.value!!,
                viewModel.valGreen.value!!,
                viewModel.valBlue.value!!
            )


            //binding.frameDisplay.background
        })
    }

    fun setNewColor(red: Int, green: Int, blue: Int) {

        view?.setBackgroundColor(Color.argb(255,red,green, blue))
        binding.textColorCodeHex.text= viewModel.getHexColorCode()
        binding.textColorCodeRGB.text= viewModel.getRGBColorCode()
    }

    fun setHtmlColorCode():String=""



}