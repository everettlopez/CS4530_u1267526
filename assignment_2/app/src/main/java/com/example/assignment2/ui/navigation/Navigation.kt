package com.example.assignment2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment2.ui.screens.AddCourseScreen
import com.example.assignment2.ui.screens.CourseDetailScreen
import com.example.assignment2.ui.screens.CourseListScreen

@Composable
fun AppNavigation()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination="list")
    {
        composable("list")
        {
            CourseListScreen(navController)
        }
        composable("add")
        {
            AddCourseScreen(navController)
        }
        composable("detail")
        {
            CourseDetailScreen(navController)
        }
    }
}