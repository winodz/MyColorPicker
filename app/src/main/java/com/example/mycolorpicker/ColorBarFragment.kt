package com.example.mycolorpicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import com.example.mycolorpicker.databinding.FragmentColorBarBinding

import java.nio.channels.Selector



/**
 * A simple [Fragment] subclass.
 * Use the [ColorBarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorBarFragment : Fragment() {


    private lateinit var itemSelector: Selector  // WHAT IS THE USE OF THIS?

    private lateinit var viewModel: SharedViewModel
    private lateinit var binding : FragmentColorBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_color_bar, container, false)
        binding = FragmentColorBarBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val skLs = MySeekListener()
        /*
        view.findViewById<SeekBar>(R.id.seekBarRed).setOnSeekBarChangeListener(skLs)
        view.findViewById<SeekBar>(R.id.seekBarGreen).setOnSeekBarChangeListener(skLs)
        view.findViewById<SeekBar>(R.id.seekBarBlue).setOnSeekBarChangeListener(skLs)
        */
        binding.seekBarRed.setOnSeekBarChangeListener(skLs)
        binding.seekBarGreen.setOnSeekBarChangeListener(skLs)
        binding.seekBarBlue.setOnSeekBarChangeListener(skLs)
    }


    inner class MySeekListener : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            seekBar?.let {

                when(it.id){
                    R.id.seekBarRed -> viewModel.setRed(progress)
                    R.id.seekBarGreen -> viewModel.setGreen(progress)
                    R.id.seekBarBlue -> viewModel.setBlue(progress)
                }


            }




        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {

        }
    }


}












