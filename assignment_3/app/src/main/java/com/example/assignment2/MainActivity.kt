package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignment2.ui.navigation.AppNavigation
import com.example.assignment2.ui.theme.Assignment2Theme
import com.example.assignment2.viewmodel.CourseViewModel
import com.example.assignment2.viewmodel.CourseViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val app = application as CourseApplication

        setContent {
            Assignment2Theme {
                val courseViewModel: CourseViewModel = viewModel(
                    factory = CourseViewModelFactory(app.repository)
                )
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(courseViewModel)
                    }
                }
            }
        }
    }
}
