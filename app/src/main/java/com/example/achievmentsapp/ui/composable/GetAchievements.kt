package com.example.achievmentsapp.ui.composable

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
    records.forEachIndexed { index, record ->
        Row(
                modifier = modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
            ){
                if (index.isEven){
                    AchievementItem(record = record, modifier = Modifier.fillMaxWidth(0.5f))
                    if (index +1 <records.size){
                        AchievementItem(record = records[index +1], modifier = Modifier.fillMaxWidth())
                    }
                }
        }
    }
}
private val Int.isEven:Boolean
    get(){
    return if(this == 0)
        true
    else this.mod(2) == 0

    }