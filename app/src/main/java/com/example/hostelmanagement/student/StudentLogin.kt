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
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.databinding.FragmentStudentLoginBinding

class StudentLogin : Fragment() {


    lateinit var binding: FragmentStudentLoginBinding
    lateinit var viewModel: StudentViewModel
    lateinit var singleStudent: Student
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
                    StudentLoginDirections.actionStudentLoginToAfterLogin(
                        enteredName,
                        enteredUsn,
                        singleStudent
                    )
                )
            }
        }
        val application = requireNotNull(activity).application
        viewModel = StudentViewModel(application)


        return binding.root
    }

    private fun loginSuccessful(): Boolean {
        val studentList: List<Student> = getstudentList()
        if (binding.usnEditext.text.toString() == "") {
            Toast.makeText(context, "Empty Name Field", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.nameEditext.text.toString() == "") {
            Toast.makeText(context, "Empty USN Field", Toast.LENGTH_SHORT).show()
            return false
        } else {
            for (i in studentList) {
                if (i.name == binding.nameEditext.toString() && i.USN == binding.usnEditext.toString()) {
                    singleStudent = i
                    return true
                }
            }
        }
        Toast.makeText(context, "Wrong Details", Toast.LENGTH_SHORT).show()
        return false
    }

    private fun getstudentList(): List<Student> {
        return viewModel.allstudents
    }
}




