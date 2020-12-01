package com.example.hostelmanagement.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentStudentLoginBinding

class StudentLogin : Fragment() {

    companion object {
        const val ANKUSH_USN: String = "18BBTCS012"
        const val AMAR_USN: String = "18BBTCS009"
        const val AKASH_USN: String = "18BBTCS006"
        const val ADARSH_USN: String = "18BBTCS005"
    }

    lateinit var binding: FragmentStudentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_student_login,
            container,
            false
        )
        //set on click listener
        binding.loginButton.setOnClickListener {
            if (loginSuccessful()) {
                val enteredName = binding.nameEditext.text.toString()
                val enteredUsn = binding.usnEditext.text.toString()
                it.findNavController().navigate(
                    StudentLoginDirections.actionStudentLoginToAfterLogin(enteredName, enteredUsn)
                )
            }
        }
        return binding.root
    }

    private fun loginSuccessful(): Boolean {
        if (binding.usnEditext.text.toString() == "") {
            Toast.makeText(context, "Empty USN Field", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.nameEditext.text.toString() == "") {
            Toast.makeText(context, "Empty NAME Field", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.usnEditext.text.toString() == ANKUSH_USN
            || binding.usnEditext.text.toString() == ADARSH_USN
            || binding.usnEditext.text.toString() == AKASH_USN
            || binding.usnEditext.text.toString() == AMAR_USN
        ) {
            return true
        }
        Toast.makeText(context, "Wrong Details", Toast.LENGTH_SHORT).show()
        return false
    }


}




