package com.example.achievmentsapp.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.achievmentsapp.domain.models.Data

@Composable
fun AchievementsTitles(data:Data){
    Row(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = data.title,
            fontSize = 22.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = data.label,
            fontSize = 16.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}