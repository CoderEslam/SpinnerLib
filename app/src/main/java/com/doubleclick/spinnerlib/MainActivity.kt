package com.doubleclick.spinnerlib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.codereslam.spinner.Spinner
import com.doubleclick.spinnerlib.ui.theme.SpinnerLibTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<SpinnerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state by viewModel.spinnerState.collectAsState()
            SpinnerLibTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Spinner(
                            items = list,
                            selectedItem = state.s,
                            onItemSelected = {
                                viewModel.onEvent(SpinnerEvent.Choose(it))
                            },
                            itemToString = { it.name }
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpinnerLibTheme {
        Greeting("Android")
    }
}

data class Eslam(
    val name: String,
    val age: Int
)

val list = listOf(
    Eslam("Eslma", 5),
    Eslam("Alaa", 55),
    Eslam("Ali", 56),
    Eslam("Ahmed", 52),
    Eslam("Hossam", 51),
    Eslam("Ibrahim", 599)
)