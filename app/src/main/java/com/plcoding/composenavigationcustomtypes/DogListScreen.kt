package com.plcoding.composenavigationcustomtypes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DogListScreen(
    onDogClick: (Dog, BreedSize) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(SAMPLE_DATA_DOGS.keys.toList()) { dog ->
            Text(
                text = dog.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onDogClick(dog, SAMPLE_DATA_DOGS[dog]!!)
                    }
                    .padding(16.dp)
            )
        }
    }
}

val SAMPLE_DATA_DOGS = mapOf(
    Dog(1, "Golden Retriever") to BreedSize.LARGE,
    Dog(2, "Labrador Retriever") to BreedSize.LARGE,
    Dog(3, "German Shepherd") to BreedSize.LARGE,
    Dog(4, "Poodle") to BreedSize.MEDIUM,
    Dog(5, "Bulldog") to BreedSize.MEDIUM,
    Dog(6, "Rottweiler") to BreedSize.LARGE,
    Dog(7, "Beagle") to BreedSize.SMALL,
    Dog(8, "Dachshund") to BreedSize.SMALL,
    Dog(9, "Boxer") to BreedSize.LARGE,
    Dog(10, "Yorkshire Terrier") to BreedSize.SMALL,
    Dog(11, "Siberian Husky") to BreedSize.LARGE,
    Dog(12, "Australian Shepherd") to BreedSize.MEDIUM,
    Dog(13, "Doberman Pinscher") to BreedSize.LARGE,
    Dog(14, "Bernese Mountain Dog") to BreedSize.LARGE,
    Dog(15, "French Bulldog") to BreedSize.SMALL,
    Dog(16, "Golden Doodle") to BreedSize.MEDIUM,
    Dog(17, "Pomeranian") to BreedSize.SMALL,
    Dog(18, "Shih Tzu") to BreedSize.SMALL,
    Dog(19, "Great Dane") to BreedSize.LARGE,
    Dog(20, "Border Collie") to BreedSize.MEDIUM,
)