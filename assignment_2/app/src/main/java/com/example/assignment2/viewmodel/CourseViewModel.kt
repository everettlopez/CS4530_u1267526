package com.example.assignment2.viewmodel

import androidx.lifecycle.ViewModel
import com.example.assignment2.model.Course
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CourseViewModel : ViewModel() {
    var courses = MutableStateFlow<List<Course>>(emptyList())

    private var courseId = 1

    fun addNewCourse(department: String, number: Int, location: String)
    {
        courses.value += Course(courseId++, department, number, location)
    }

    fun deleteCourse(courseId: Int){
        courses.value = courses.value.filter { it.id != courseId }
    }
}

