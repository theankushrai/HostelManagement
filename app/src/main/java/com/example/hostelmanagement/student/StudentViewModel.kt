package com.example.hostelmanagement.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hostelmanagement.database.HostelDatabase
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.database.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: StudentRepository
    lateinit var allstudents: List<Student>


    init {
        val dao = HostelDatabase.getDatabase(application).getStudentDao()
        repository = StudentRepository(dao)
        initializeallstudetns()
    }

    fun initializeallstudetns() {
        viewModelScope.launch {
            allstudents = getStudentListfromrepository()
        }
    }

    suspend fun getStudentListfromrepository(): List<Student> {
        val studentList = repository.getStudentDetails()
        return studentList
    }


}