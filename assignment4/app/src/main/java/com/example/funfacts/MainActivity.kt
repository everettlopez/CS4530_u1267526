package com.example.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.funfacts.ui.FunFactScreen
import com.example.funfacts.ui.FunFactViewModel
import com.example.funfacts.ui.theme.FunFactsTheme

class MainActivity : ComponentActivity() {

    private val viewModel: FunFactViewModel by viewModels {
        FunFactViewModel.Factory((application as FunFactsApplication).repsository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsTheme {
                FunFactScreen(viewModel)
            }
        }
    }
}