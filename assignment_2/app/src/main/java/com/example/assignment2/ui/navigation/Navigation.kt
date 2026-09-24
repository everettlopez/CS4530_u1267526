package com.example.assignment2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment2.ui.screens.AddCourseScreen
import com.example.assignment2.ui.screens.CourseDetailScreen
import com.example.assignment2.ui.screens.CourseListScreen
import com.example.assignment2.viewmodel.CourseViewModel

@Composable
fun AppNavigation(viewModel: CourseViewModel)
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination="list")
    {
        composable("list")
        {
            CourseListScreen(navController, viewModel)
        }
        composable("add")
        {
            AddCourseScreen(navController, viewModel)
        }
        composable("detail/{courseId}")
        {
            backStackEntry -> val id = backStackEntry.arguments?.getString("courseId")!!.toInt()
            CourseDetailScreen(navController, viewModel, id)
        }
    }
}