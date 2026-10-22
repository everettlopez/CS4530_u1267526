package com.example.assignment2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment2.data.CourseRepository
import com.example.assignment2.model.Course
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CourseViewModel(private val repository: CourseRepository) : ViewModel() {

    val courses: StateFlow<List<Course>> = repository.allCourses.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addNewCourse(department: String, number: Int, location: String) {
        viewModelScope.launch {
            repository.insertCourse(department, number, location)
        }
    }

    fun deleteCourse(courseId: Int) {
        viewModelScope.launch {
            repository.deleteCourse(courseId)
        }
    }

    fun getCourseById(id: Int): Course? {
        return courses.value.find { it.id == id }
    }

    fun updateCourse(courseId: Int, department: String, number: Int, location: String) {
        viewModelScope.launch {
            repository.updateCourse(courseId, department, number, location)
        }
    }
}
