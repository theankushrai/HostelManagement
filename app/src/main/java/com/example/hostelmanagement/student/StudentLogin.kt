package com.example.hostelmanagement.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentStudentLoginBinding

class StudentLogin : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding:FragmentStudentLoginBinding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_student_login,container,false)

        //set on click listener
        binding.loginButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_studentLogin_to_afterLogin)
        }

        return binding.root
    }

}