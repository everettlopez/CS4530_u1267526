package com.example.assignment2.data

import com.example.assignment2.model.Course
import kotlinx.coroutines.flow.Flow

class CourseRepository private constructor(private val courseDao: CourseDao) {

    val allCourses: Flow<List<Course>> = courseDao.getAllCourses()

    suspend fun getCourseById(id: Int): Course? {
        return courseDao.getCourseById(id)
    }

    suspend fun insertCourse(department: String, number: Int, location: String) {
        val course = Course(department = department, number = number, location = location)
        courseDao.insertCourse(course)
    }

    suspend fun updateCourse(id: Int, department: String, number: Int, location: String) {
        val course = Course(id = id, department = department, number = number, location = location)
        courseDao.updateCourse(course)
    }

    suspend fun deleteCourse(id: Int) {
        courseDao.deleteCourseById(id)
    }

    companion object {
        @Volatile
        private var INSTANCE: CourseRepository? = null

        fun getInstance(courseDao: CourseDao): CourseRepository {
            return INSTANCE ?: synchronized(this) {
                val instance = CourseRepository(courseDao)
                INSTANCE = instance
                instance
            }
        }
    }
}
