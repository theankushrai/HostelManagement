package com.example.hostelmanagement.student

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.hostelmanagement.database.HostelDatabase
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.database.StudentRepository

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: StudentRepository
    var allstudents: LiveData<List<Student>>


    init {
        val dao = HostelDatabase.getDatabase(application).getStudentDao()
        repository = StudentRepository(dao)
//        initializeallstudetns()
        allstudents = repository.getStudentDetails()
    }
//
//     fun initializeallstudetns() {
//        viewModelScope.launch {
//            allstudents = getStudentListfromrepository()
//        }
//    }
//
//    private suspend fun getStudentListfromrepository(): LiveData<List<Student>> {
//        val studentList = repository.getStudentDetails()
//        return studentList
//    }
//    fun insert(student: Student){
//        viewModelScope.launch {
//            repository.insert(student)
//        }
//    }


}