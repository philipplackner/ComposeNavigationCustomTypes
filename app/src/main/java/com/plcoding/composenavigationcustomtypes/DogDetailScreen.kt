package com.plcoding.composenavigationcustomtypes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DogDetailScreen(
    dog: Dog,
    breedSize: BreedSize
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${dog.name} with the ID of ${dog.id} has the breed size $breedSize"
        )
    }
}