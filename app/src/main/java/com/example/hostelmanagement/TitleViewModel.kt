package com.example.hostelmanagement

import android.app.Application
import android.content.res.Resources
import android.graphics.BitmapFactory
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.hostelmanagement.database.HostelDatabase
import com.example.hostelmanagement.database.Student
import com.example.hostelmanagement.database.StudentRepository
import kotlinx.coroutines.launch

class TitleViewModel(application: Application, private val resources: Resources) : AndroidViewModel(application) {

    private val studentRepository: StudentRepository

    init {
        val studentDao = HostelDatabase.getDatabase(application).getStudentDao()
        studentRepository = StudentRepository(studentDao)
    }

    fun insert(student: Student) {
        viewModelScope.launch {
            studentRepository.insert(student)
        }
    }

    fun prepopulate() {
        val ANKUSH = Student("Ankush Rai", "18BBTCS012", 26, "Seoni M.P.", "ankushrai96@gmail.com",
                9109547055, 65, BitmapFactory.decodeResource(resources, R.drawable.ankush))
        val AMARTYA = Student("Amartya Dey", "18BBTCS009", 89, "Kolkate W.B.", "amartyadey@gmail.com",
                9425727070, 89, BitmapFactory.decodeResource(resources, R.drawable.amar))
        val ADARSH = Student("Adarsh Kumar", "18BBTCS005", 82, "Patna Bihar", "adarshbud@gmail.com",
                9425898785, 78, BitmapFactory.decodeResource(resources, R.drawable.adarsh))
        val AKASH = Student("Akash Yadav", "18BBTCS006", 56, "Bangalore Karnataka", "akashyadav@gmail.com",
                9109569592, 55, BitmapFactory.decodeResource(resources, R.drawable.akash))
        insert(ANKUSH)
        insert(ADARSH)
        insert(AKASH)
        insert(AMARTYA)
    }

}