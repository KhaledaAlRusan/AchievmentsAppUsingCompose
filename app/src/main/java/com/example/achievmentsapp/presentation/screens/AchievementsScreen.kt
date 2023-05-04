package com.example.achievmentsapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.achievmentsapp.domain.models.Data
import com.example.achievmentsapp.domain.models.Record
import com.example.achievmentsapp.presentation.composable.AchievementItem
import com.example.achievmentsapp.presentation.composable.GetAchievements
import com.example.achievmentsapp.presentation.viewmodel.AchievementsViewModel

@Composable
fun AchievementsScreen(
    viewModel: AchievementsViewModel = hiltViewModel()
){
    val state by viewModel.getSuccess.collectAsState()

    //state.firstOrNull()?.let { AchievementsContent(data = it) }
    AchievementsContent(data = state)
}





@Composable
fun AchievementsContent(
    data: List<Data>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp),
    ){
        items(data.size){ index ->
            Column(modifier = Modifier.fillMaxWidth().height(580.dp)){
                Row(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = data[index].title,
                        textAlign = TextAlign.Start,
                        fontSize = 22.sp
                    )
                    Text(
                        text = data[index].label,
                        textAlign = TextAlign.Justify,
                        fontSize = 16.sp
                    )
                }

                GetAchievements(records = data[index].records)

            }
        }
    }
}
