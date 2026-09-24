package com.example.assignment2.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(12.dp)).padding(16.dp))
        {
            // Title
            Text(text = "Course List Screen", modifier = Modifier.padding(vertical = 8.dp), fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Button(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(12.dp)
                    ),
                onClick = { navController.navigate("add") },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE5E7EB)
                )
            ) {
                Text(text = "Add New Course", fontSize = 16.sp, color = Color.Black)
            }


            LazyColumn(modifier = Modifier.border(2.dp, Color.Black))
            {
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

