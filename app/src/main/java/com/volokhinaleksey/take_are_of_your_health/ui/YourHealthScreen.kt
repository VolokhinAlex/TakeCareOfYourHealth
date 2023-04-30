package com.volokhinaleksey.take_are_of_your_health.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.volokhinaleksey.take_are_of_your_health.models.state.ResponseState
import com.volokhinaleksey.take_are_of_your_health.models.ui.YourHealthDataUI
import com.volokhinaleksey.take_are_of_your_health.ui.widgets.HealthCard
import com.volokhinaleksey.take_are_of_your_health.ui.widgets.InputAlertDialog
import com.volokhinaleksey.take_are_of_your_health.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun YourHealthScreen(homeViewModel: HomeViewModel = koinViewModel()) {
    var isShowDialog by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 10.dp)
    ) {
        homeViewModel.getDataAboutYourHealth().observeAsState().value?.let {
            ObserverResponse(state = it)
        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingActionButton(onClick = {
                isShowDialog = true
            }, containerColor = Color.Red) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Add new data about your health",
                    tint = Color.White
                )
            }
        }
    }
    if (isShowDialog) {
        InputAlertDialog(onDismissRequest = { isShowDialog = false }, onSaveRequest = {
            homeViewModel.saveDataAboutYourHealth(dataUI = it)
            isShowDialog = false
        })
    }
}

@Composable
fun ObserverResponse(state: ResponseState<List<YourHealthDataUI>>) {
    when (state) {
        is ResponseState.Error -> {}
        ResponseState.Loading -> {}
        is ResponseState.Success -> {
            val data = state.data
            ShowListAboutYourHealth(data)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowListAboutYourHealth(data: List<YourHealthDataUI>) {
    val itemsByDate = data.groupBy { it.date }
    LazyColumn {
        itemsByDate.forEach { (date, items) ->
            stickyHeader {
                Box(modifier = Modifier.padding(10.dp)) {
                    Text(text = date)
                }
            }
            itemsIndexed(items) { _, item ->
                HealthCard(item)
            }
        }
    }
}