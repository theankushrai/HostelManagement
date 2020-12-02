package com.example.hostelmanagement.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoticeDao {

    @Query("SELECT * FROM studentnotice")
    fun getAllNotice(): LiveData<List<StudentNotice>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNotice(notice: StudentNotice)
}