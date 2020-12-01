package com.example.hostelmanagement.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentNoticeDao {

    @Query("SELECT * FROM studentnotice")
    fun getAllStudentNotice(): LiveData<List<StudentNotice>>

    @Insert
    suspend fun insertNotice(notice: StudentNotice)

    @Delete
    suspend fun deleteNotice(notice: StudentNotice)

}