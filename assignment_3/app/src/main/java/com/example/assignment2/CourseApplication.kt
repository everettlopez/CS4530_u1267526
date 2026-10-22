package com.example.assignment2

import android.app.Application
import com.example.assignment2.data.CourseDatabase
import com.example.assignment2.data.CourseRepository

class CourseApplication : Application() {
    val database by lazy { CourseDatabase.getDatabase(this) }
    val repository by lazy { CourseRepository.getInstance(database.courseDao()) }
}
