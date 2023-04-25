package com.volokhinaleksey.take_are_of_your_health.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volokhinaleksey.take_are_of_your_health.models.ui.YourHealthDataUI
import com.volokhinaleksey.take_are_of_your_health.utils.getCurrentDateTime
import com.volokhinaleksey.take_are_of_your_health.utils.toString

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputAlertDialog(
    onDismissRequest: () -> Unit,
    onSaveRequest: (YourHealthDataUI) -> Unit
) {
    var pulse by rememberSaveable {
        mutableStateOf("")
    }
    var systolicPressure by rememberSaveable {
        mutableStateOf("")
    }
    var diastolicPressure by rememberSaveable {
        mutableStateOf("")
    }
    AlertDialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            shape = MaterialTheme.shapes.large,
            color = MaterialTheme.colorScheme.onBackground
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                TextField(value = pulse, onValueChange = {
                    pulse = it
                }, modifier = Modifier.padding(10.dp),
                    placeholder = { Text(text = "Pulse") })
                TextField(value = systolicPressure, onValueChange = {
                    systolicPressure = it
                }, modifier = Modifier.padding(10.dp, 0.dp),
                    placeholder = { Text(text = "Systolic pressure") })
                TextField(value = diastolicPressure, onValueChange = {
                    diastolicPressure = it
                }, modifier = Modifier.padding(10.dp),
                    placeholder = { Text(text = "Diastolic pressure") })
                Button(onClick = {
                    if (pulse.isNotEmpty() && systolicPressure.isNotEmpty() && diastolicPressure.isNotEmpty()) {
                        onSaveRequest(
                            YourHealthDataUI(
                                date = getCurrentDateTime().toString("yyyy/MM/dd"),
                                time = getCurrentDateTime().toString("HH:mm"),
                                pulse = pulse.toIntOrNull() ?: 0,
                                systolicPressure = systolicPressure.toIntOrNull() ?: 0,
                                diastolicPressure = diastolicPressure.toIntOrNull() ?: 0
                            )
                        )
                    }
                }, modifier = Modifier.padding(bottom = 10.dp, start = 10.dp, end = 10.dp)) {
                    Text(text = "Add new data")
                }
            }
        }
    }

}