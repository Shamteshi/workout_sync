package com.workoutsync.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun SyncHome(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    presenter: SyncPresenter = hiltViewModel()
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            CustomButton(heldValue = presenter.state.chestAndBackCount, cardName =  "Chest And Back") {
                presenter.chestAndBack()
            }
        }

        item {
            CustomButton(heldValue = presenter.state.bicepsAndTricepsCount, cardName =  "Biceps And Triceps") {
                presenter.bicepsAndTriceps()
            }
        }

        item {
            CustomButton(heldValue = presenter.state.shoulderAndCalvesCount, cardName =  "Shoulder And Calves") {
                presenter.shoulderAndCalves()
            }
        }

        item {
            CustomButton(heldValue = presenter.state.quadsAndHamstringsCount, cardName =  "Quads And Hamstrings") {
                presenter.quadsAndHamstrings()
            }
        }

    }
}


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    cardName: String,
    heldValue: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Card(
            modifier = modifier
                .height(150.dp)
                .width(200.dp)
                .clip(RoundedCornerShape(50.dp))
                .clickable { onClick.invoke() },
            shape = RoundedCornerShape(50.dp)
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = cardName)
            }
        }

        Text(text = "x", style = TextStyle(fontSize = 40.sp))
        Text(text = heldValue.toString(), style = TextStyle(fontSize = 70.sp))
    }
}