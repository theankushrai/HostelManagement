package com.example.hostelmanagement.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.hostelmanagement.R
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.databinding.FragmentPersonalDetailsBinding

class PersonalDetails : Fragment() {
    lateinit var binding: FragmentPersonalDetailsBinding
    lateinit var viewModel: StudentViewModel
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
        val student: Student = PersonalDetailsArgs.fromBundle(requireArguments()).singleStudent
        binding.RoomnoTextView.text = student.room_no.toString()
        binding.USNtextview.text = student.USN
        binding.emailTextView.text = student.e_mail
        binding.fullnametextview.text = student.name
        binding.mobilenoTetview.text = student.mobile_no.toString()

    }

}