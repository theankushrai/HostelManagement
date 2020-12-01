package com.example.hostelmanagement.Parents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentParentsInformationBinding


class ParentsInformation : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentParentsInformationBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_parents_information,
            container,
            false
        )

        //setting on click listeners
        binding.searchButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_parentsInformation_to_personalDetails)
        }

        return binding.root
    }

}