package com.example.hostelmanagement.student

import android.app.Application
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.hostelmanagement.R
import com.example.hostelmanagement.database.*
import com.example.hostelmanagement.database.StudentNotice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentViewModel(application: Application, private val resources: Resources) : AndroidViewModel(application) {
    private val studentRepository: StudentRepository
    private val noticeRepository: NoticeRepository
    var allstudents: LiveData<List<Student>>
    var allNotice: LiveData<List<StudentNotice>>
    var singleStudent: Student? = null

    companion object {
        val ANKUSH = Student("Ankush Rai", "18BBTCS012", 26, "Seoni M.P.", "ankushrai96@gmail.com",
                9109547055, 65)
        val AMARTYA = Student("Amartya Dey", "18BBTCS009", 89, "Kolkate W.B.", "amartyadey@gmail.com",
                9425727070, 89)
        val ADARSH = Student("Adarsk Kumar", "18BBTCS005", 82, "Patna Bihar", "adarshbud@gmail.com",
                9425898785, 78)
        val AKASH = Student("Akash Yadav", "18BBTCS006", 56, "Bangalore Karnataka", "akashyadav@gmail.com",
                9109569592, 55)
    }

    init {
        val studentDao = HostelDatabase.getDatabase(application).getStudentDao()
        studentRepository = StudentRepository(studentDao)
        val noticeDao = HostelDatabase.getDatabase(application).getNoticeDao()
        noticeRepository = NoticeRepository(noticeDao)
        //prepopulating the database
        prepopulate()
        allstudents = studentRepository.getStudentDetails()
        allNotice = noticeRepository.getAllNotice()
    }

    fun verifyLogin(name: String, usn: String) {
        viewModelScope.launch {
            val student = studentRepository.verifyLogin(name, usn)
            withContext(Dispatchers.Main) {
                singleStudent = student
            }
        }
    }

    fun insert(student: Student) {
        viewModelScope.launch {
            studentRepository.insert(student)
        }
    }

    fun insertNOtice(notice: StudentNotice) {
        viewModelScope.launch {
            noticeRepository.insertNotice(notice)
        }
    }

    fun updateAttendence(student: Student) {
        viewModelScope.launch {
            studentRepository.updateAttendence(student)
        }
    }

    private fun prepopulate() {
        insert(ANKUSH)
        insert(ADARSH)
        insert(AKASH)
        insert(AMARTYA)
        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.cmr_logo)
        insertNOtice(StudentNotice(bitmap))
    }
}