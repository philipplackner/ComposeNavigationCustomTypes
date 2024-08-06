package com.plcoding.composenavigationcustomtypes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.plcoding.composenavigationcustomtypes.ui.theme.ComposeNavigationCustomTypesTheme
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data object DogListRoute

@Serializable
data class DogDetailRoute(
    val dog: Dog,
    val breedSize: BreedSize
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationCustomTypesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = DogListRoute,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<DogListRoute> {
                            DogListScreen(
                                onDogClick = { dog, breedSize ->
                                    navController.navigate(
                                        DogDetailRoute(
                                            dog = dog,
                                            breedSize = breedSize
                                        )
                                    )
                                }
                            )
                        }
                        composable<DogDetailRoute>(
                            typeMap = mapOf(
                                typeOf<Dog>() to CustomNavType.DogType,
                                typeOf<BreedSize>() to NavType.EnumType(BreedSize::class.java)
                            )
                        ) {
                            val arguments = it.toRoute<DogDetailRoute>()
                            DogDetailScreen(
                                dog = arguments.dog,
                                breedSize = arguments.breedSize
                            )
                        }
                    }
                }
            }
        }
    }
}