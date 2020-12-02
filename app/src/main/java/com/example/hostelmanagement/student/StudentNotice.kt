package com.example.hostelmanagement.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hostelmanagement.Adapters.NoticeAdapter
import com.example.hostelmanagement.R
import com.example.hostelmanagement.databinding.FragmentStudentNoticeBinding

class StudentNotice : Fragment() {
    lateinit var binding: FragmentStudentNoticeBinding
    lateinit var viewModel: StudentViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_student_notice, container, false)
        val application = requireNotNull(activity).application
        viewModel = StudentViewModel(application, resources)
        val adapter = NoticeAdapter()

        viewModel.allNotice.observe(viewLifecycleOwner, { list ->
            list?.let {
                adapter.submitList(it)
            }
        })

        //setting the layoutmanager
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        //intializing viewmodel and lifecycle owner
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.recyclerView.adapter = adapter
        return binding.root
    }

}