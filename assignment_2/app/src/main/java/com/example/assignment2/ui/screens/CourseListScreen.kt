package com.example.assignment2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment2.viewmodel.CourseViewModel

@Composable
fun CourseListScreen(navController: NavController, viewModel: CourseViewModel)
{
    val courseList by viewModel.courses.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Button(onClick = { navController.navigate("add") }) {
                Text("Add New Course")
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                for (course in courseList) {
                    item {
                        Button(onClick = {navController.navigate("detail/${course.id}")})
                        {
                            Text("${course.department} ${course.number} - ${course.location}")
                        }
                    }
                }
            }
        }
    }
}

