package com.example.achievmentsapp.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.achievmentsapp.domain.models.Data
import com.example.achievmentsapp.ui.composable.AchievementsTitles
import com.example.achievmentsapp.ui.composable.GetAchievements
import com.example.achievmentsapp.ui.viewmodel.AchievementsViewModel

@Composable
fun AchievementsScreen(
    viewModel: AchievementsViewModel = hiltViewModel()
){
    val dataSuccess by viewModel.getSuccess.collectAsState()

    AchievementsContent(data = dataSuccess)
}





@Composable
fun AchievementsContent(
    data: List<Data>,
    modifier: Modifier = Modifier
) {
    val state = rememberScrollState()
    Column(
        modifier = modifier.padding(start = 16.dp, end = 16.dp).verticalScroll(state),
    ){
        data.forEach {data ->
            AchievementsTitles(data = data)
            GetAchievements(records = data.records)
        }
    }
}
