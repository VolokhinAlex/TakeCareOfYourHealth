package com.volokhinaleksey.take_are_of_your_health.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volokhinaleksey.take_are_of_your_health.models.ui.YourHealthDataUI

@Composable
fun HealthCard(data: YourHealthDataUI) {
    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = data.time, fontSize = 16.sp, color = Color.Gray)
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = data.systolicPressure.toString(), fontSize = 20.sp, color = Color.Black)
            Text(
                text = "/",
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 0.dp)
            )
            Text(text = data.diastolicPressure.toString(), fontSize = 20.sp, color = Color.Black)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Your Pulse",
                tint = Color.Gray,
                modifier = Modifier
                    .size(18.dp)
                    .padding(end = 5.dp)
            )
            Text(text = data.pulse.toString(), fontSize = 20.sp, color = Color.Gray)
        }
    }
    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth()
    )
}
