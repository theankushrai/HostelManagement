package com.example.hostelmanagement.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentPersonalDetailsBinding

class PersonalDetails : Fragment() {
    lateinit var binding: FragmentPersonalDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_personal_details,
            container,
            false
        )

        //displaying recieved data
        displayData()
        return binding.root
    }

    private fun displayData() {
        val args = PersonalDetailsArgs.fromBundle(requireArguments())
        when (args.enteredUsn) {
            "18BBTCS012" -> displayAnkushData()
            "18BBTCS009" -> displayAmarData()
            "18BBTCS006" -> displayAkashData()
            "18BBTCS005" -> diaplayAdarshData()
        }
    }

    private fun displayAkashData() {
        binding.RoomnoTextView.text = "201"
        binding.USNtextview.text = "18BBTCS006"
        binding.emailTextView.text = "akashyadav@gmail.com"
        binding.fullnametextview.text = "Akash Yadav"
        binding.mobilenoTetview.text = "9425758965"
    }

    private fun displayAmarData() {
        binding.RoomnoTextView.text = "202"
        binding.USNtextview.text = "18BBTCS009"
        binding.emailTextView.text = "amartyaDey@gmail.com"
        binding.fullnametextview.text = "Amartya Dey"
        binding.mobilenoTetview.text = "9425758965"
    }

    private fun diaplayAdarshData() {
        binding.RoomnoTextView.text = "203"
        binding.USNtextview.text = "18BBTCS005"
        binding.emailTextView.text = "adarshkumar@gmail.com"
        binding.fullnametextview.text = "Adarsh Kumar"
        binding.mobilenoTetview.text = "9425758965"
    }

    private fun displayAnkushData() {
        binding.RoomnoTextView.text = "204"
        binding.USNtextview.text = "18BBTCS012"
        binding.emailTextView.text = "ankushrai@gmail.com"
        binding.fullnametextview.text = "Ankush Rai"
        binding.mobilenoTetview.text = "9425758965"
    }

}