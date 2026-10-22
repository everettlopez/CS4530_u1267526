package com.example.assignment2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment2.viewmodel.CourseViewModel

@Composable
fun CourseDetailScreen(navController: NavController, viewModel: CourseViewModel, courseId: Int) {

    val course = viewModel.courses.collectAsState().value
        .firstOrNull { it.id == courseId }

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text("Course Details")
            if (course != null) {
                Text("Department: ${course.department}")
                Text("Number: ${course.number}")
                Text("Location: ${course.location}")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row()
            {
                Button(onClick = {navController.navigate("list")})
                {
                    Text("Back")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(onClick = {
                    navController.navigate("list")
                    viewModel.deleteCourse(courseId)
                })
                {
                    Text("Delete")
                }

                Button(onClick = {navController.navigate("edit/${course?.id}")})
                {
                    Text("Edit Course")
                }
            }
        }
    }
}
