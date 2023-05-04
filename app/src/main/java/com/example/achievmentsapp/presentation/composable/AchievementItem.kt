package com.example.achievmentsapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.achievmentsapp.domain.models.Record

@Composable
fun AchievementItem(
    record:Record,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.wrapContentHeight(),
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = record.image),
                contentDescription = "Achievement Medal",
                modifier = Modifier
                    .width(110.dp)
                    .height(110.dp)
            )
            Text(text = record.title)

            Text(text = record.label)

        }
    }
}