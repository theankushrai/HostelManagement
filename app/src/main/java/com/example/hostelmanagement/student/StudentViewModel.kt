package com.example.hostelmanagement.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.hostelmanagement.database.HostelDatabase
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.database.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: StudentRepository
    var allstudents: LiveData<List<Student>>
    var singleStudent: Student? = null


    init {
        val dao = HostelDatabase.getDatabase(application).getStudentDao()
        repository = StudentRepository(dao)
        allstudents = repository.getStudentDetails()
    }

    fun verifyLogin(name: String, usn: String) {
        viewModelScope.launch {
            val student = repository.verifyLogin(name, usn)
            withContext(Dispatchers.Main) {
                singleStudent = student
            }
        }
    }

    fun insert(student: Student) {
        viewModelScope.launch {
            repository.insert(student)
        }
    }

    fun updateAttendence(student: Student) {
        viewModelScope.launch {
            repository.updateAttendence(student)
        }
    }


}