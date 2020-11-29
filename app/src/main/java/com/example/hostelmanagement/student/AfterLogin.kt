package com.example.hostelmanagement.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentAfterLoginBinding

class AfterLogin : Fragment() {

    private lateinit var  binding:FragmentAfterLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_after_login,container,false)

        //setting on click listener
        binding.personalDetailsButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_afterLogin_to_personalDetails)
        }
        binding.attendenceButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_afterLogin_to_personalDetails)
        }
        binding.studentNoticeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_afterLogin_to_studentNotice)
        }
        binding.messMenuButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_afterLogin_to_messMenu)
        }
        binding.informationButton.setOnClickListener {
            onInformationButtonClick()
        }
        binding.backButton.setOnClickListener {
            onBackButtonClick()
        }

        //back pressed callback
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_afterLogin_to_titleFragment22)
            }
        })


        return binding.root

    }
    fun onInformationButtonClick(){
        binding.messMenuButton.visibility=View.VISIBLE
        binding.studentNoticeButton.visibility=View.VISIBLE
        binding.backButton.visibility=View.VISIBLE
        binding.personalDetailsButton.visibility=View.INVISIBLE
        binding.hostelName.visibility=View.INVISIBLE
        binding.attendenceButton.visibility=View.INVISIBLE
        binding.informationButton.visibility=View.INVISIBLE
    }
    fun onBackButtonClick(){
        binding.messMenuButton.visibility=View.GONE
        binding.studentNoticeButton.visibility=View.GONE
        binding.backButton.visibility=View.GONE
        binding.personalDetailsButton.visibility=View.VISIBLE
        binding.hostelName.visibility=View.VISIBLE
        binding.attendenceButton.visibility=View.VISIBLE
        binding.informationButton.visibility=View.VISIBLE
    }

}