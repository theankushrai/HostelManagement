package com.example.hostelmanagement.warden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentWardenLoginBinding

class WardenLogin : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentWardenLoginBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_warden_login,
            container,
            false
        )

        //seting on click listeners

        binding.wardenLoginButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_wardenLogin_to_wardenAfterLogin)
        }


        return binding.root
    }

}