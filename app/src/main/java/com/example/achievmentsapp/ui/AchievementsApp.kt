package com.example.achievmentsapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.achievmentsapp.ui.composable.CircularBar
import com.example.achievmentsapp.ui.screens.AchievementsScreen
import com.example.achievmentsapp.ui.screens.ErrorScreen
import com.example.achievmentsapp.ui.viewmodel.AchievementsViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AchievementsApp() {
    val viewModel: AchievementsViewModel = hiltViewModel()
    val loading = viewModel.getLoading.collectAsState().value
    val error = viewModel.getError.collectAsState().value

    Scaffold {
        when{
            loading -> CircularBar()
            error != null -> ErrorScreen(error)
            else -> AchievementsScreen()
        }
    }
}
