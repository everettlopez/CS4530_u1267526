package com.example.assignment2.ui.screens

import androidx.compose.foundation.border
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment2.viewmodel.CourseViewModel

@Composable
fun AddCourseScreen(navController: NavController, viewModel: CourseViewModel)
{
    var department by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center)
    {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text("ADD NEW COURSE PAGE")
            Spacer(modifier = Modifier.height(16.dp))
            TextField(value = department, onValueChange = {department = it}, label = {Text("Course Department")})
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = number, onValueChange = {number = it}, label={Text("Course Number")})
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = location, onValueChange = {location = it}, label = {Text("Course Location")})

            Spacer(modifier = Modifier.height(16.dp))

            Row()
            {
                Button(onClick = { navController.navigate("list") })
                {
                    Text("Back")
                }

                Spacer(Modifier.width(16.dp))

                Button(onClick = {
                    val numberInt = number.toIntOrNull() ?: 0
                    viewModel.addNewCourse(department, numberInt, location)
                    navController.navigate("list")})
                {
                    Text("Save Course")
                }
            }
        }
    }
}