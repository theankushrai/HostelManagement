package com.example.hostelmanagement.warden

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.hostelmanagement.database.*

class WardenViewModel(application: Application) : AndroidViewModel(application) {
    private val studentRepository: StudentRepository
    private val noticeRepository: NoticeRepository
    var allstudents: LiveData<List<Student>>
    var allNotice: LiveData<List<StudentNotice>>

    init {
        val studentDao = HostelDatabase.getDatabase(application).getStudentDao()
        studentRepository = StudentRepository(studentDao)
        val noticeDao = HostelDatabase.getDatabase(application).getNoticeDao()
        noticeRepository = NoticeRepository(noticeDao)
        allstudents = studentRepository.getStudentDetails()
        allNotice = noticeRepository.getAllNotice()
    }
}