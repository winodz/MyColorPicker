package com.example.mycolorpicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider
import layout.SharedViewModel
import java.nio.channels.Selector

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColorBarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorBarFragment : Fragment() {


    private lateinit var itemSelector: Selector  // WHAT IS THE USE OF THIS?

    private var model: SharedViewModel = TODO()

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
        return inflater.inflate(R.layout.fragment_color_bar, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val skLs = MySeekListener()
        view.findViewById<SeekBar>(R.id.seekBarRed).setOnSeekBarChangeListener(skLs)
        view.findViewById<SeekBar>(R.id.seekBarGreen).setOnSeekBarChangeListener(skLs)
        view.findViewById<SeekBar>(R.id.seekBarBlue).setOnSeekBarChangeListener(skLs)
    }


    inner class MySeekListener : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            seekBar?.let {

                when(it.id){
                    R.id.seekBarRed -> model.setRed(progress)
                    R.id.seekBarGreen -> model.setGreen(progress)
                    R.id.seekBarBlue -> model.setBlue(progress)
                }


            }




        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
            TODO("Not yet implemented")
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            TODO("Not yet implemented")
        }
    }


}








    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColorBarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ColorBarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}



