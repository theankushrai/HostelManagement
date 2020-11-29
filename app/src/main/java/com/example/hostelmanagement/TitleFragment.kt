package com.example.hostelmanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.hostelmanagement.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding:FragmentTitleBinding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_title,container,false)

        //setting onclick listeners
        binding.studentAccess.setOnClickListener {
            it.findNavController().navigate(R.id.action_titleFragment2_to_studentLogin)
        }

        return binding.root


    }


}