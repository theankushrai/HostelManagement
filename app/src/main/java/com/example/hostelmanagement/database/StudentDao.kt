package com.example.hostelmanagement.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("SELECT * FROM STUDENT ")
    suspend fun getStudentDetails(): List<Student>
}