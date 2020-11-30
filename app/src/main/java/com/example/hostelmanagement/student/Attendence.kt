package com.example.hostelmanagement.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentAttendenceBinding

class Attendence : Fragment() {

    lateinit var binding:FragmentAttendenceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_attendence,container,false)

        //On Click Listeners
        binding.submitAttendenceButton.setOnClickListener {
            onSubmitAttendence()
        }
        binding.returnToHomeButton.setOnClickListener {
            returnToHome()
        }


        return binding.root

    }

    private fun returnToHome() {
            binding.attendanceMarkedSuccessfulllyTextview.visibility=View.GONE
            binding.returnToHomeButton.visibility=View.GONE
            binding.attendenceSuccessfulImageview.visibility=View.GONE
            binding.TotalAttendenceMarkedTextview.visibility=View.VISIBLE
            binding.attendenceTextbox.visibility=View.VISIBLE
            binding.submitAttendenceButton.visibility=View.VISIBLE
        }

    private fun onSubmitAttendence() {
        if (binding.attendenceTextbox.isChecked==true){
            binding.attendanceMarkedSuccessfulllyTextview.visibility=View.VISIBLE
            binding.returnToHomeButton.visibility=View.VISIBLE
            binding.attendenceSuccessfulImageview.visibility=View.VISIBLE
            binding.TotalAttendenceMarkedTextview.visibility=View.GONE
            binding.attendenceTextbox.visibility=View.GONE
            binding.submitAttendenceButton.visibility=View.GONE
        }
        else Toast.makeText(context, "Check Box not checked", Toast.LENGTH_SHORT).show()

    }

}