package com.example.achievmentsapp.presentation.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.achievmentsapp.domain.models.Record

@Composable
fun GetAchievements(
    records:List<Record>,
    modifier: Modifier = Modifier
){

    LazyVerticalGrid(
        modifier = modifier.wrapContentHeight().fillMaxWidth(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        userScrollEnabled = false
    ){
        items(records.size){index ->
            AchievementItem(record =records[index] )
        }
    }
}