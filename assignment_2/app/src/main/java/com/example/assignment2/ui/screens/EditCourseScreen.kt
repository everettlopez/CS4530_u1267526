package com.example.assignment2.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment2.viewmodel.CourseViewModel

@Composable
fun EditCourseScreen(
    courseId: Int,
    navController: NavController,
    viewModel: CourseViewModel = viewModel()
) {
    val course = viewModel.getCourseById(courseId)
    if (course == null) {
        Text("Error: No Course Found")
        return
    }

    var department by remember { mutableStateOf(course.department) }
    var number by remember { mutableStateOf(course.number.toString()) }
    var location by remember { mutableStateOf(course.location) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("EDIT COURSE PAGE")

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = department,
                onValueChange = { department = it },
                label = { Text("Department") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = number,
                onValueChange = { number = it },
                label = { Text("Course Number") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Location") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                val numberInt = number.toIntOrNull() ?: 0
                viewModel.updateCourse(course.id, department, numberInt, location)
                navController.navigate("list")
            }) {
                Text("Save Changes")
            }
        }
    }
}
