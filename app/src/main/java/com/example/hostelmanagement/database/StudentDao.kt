package com.example.hostelmanagement.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("SELECT * FROM STUDENT ")
    fun getStudentDetails(): LiveData<List<Student>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)
}