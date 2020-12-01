package com.example.hostelmanagement.database

class StudentRepository(private val studentDao: StudentDao) {

    suspend fun getStudentDetails(): List<Student> {
        return studentDao.getStudentDetails()
    }

}