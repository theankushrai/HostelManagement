package com.example.hostelmanagement.database

import androidx.lifecycle.LiveData

class StudentNoticeRepository(private val studentNoticeDao: StudentNoticeDao) {

    val allStudentNotice: LiveData<List<StudentNotice>> = studentNoticeDao.getAllStudentNotice()

    suspend fun insertNotice(notice: StudentNotice) {
        studentNoticeDao.insertNotice(notice)
    }

    suspend fun deleteNotice(notice: StudentNotice) {
        studentNoticeDao.deleteNotice(notice)
    }
}
