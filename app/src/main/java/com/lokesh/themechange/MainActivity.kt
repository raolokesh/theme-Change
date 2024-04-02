package com.lokesh.themechange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lokesh.themechange.ui.theme.ThemeChangeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThemeChangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App("Android")
                }
            }
        }
    }
}

@Composable
fun App(name: String, modifier: Modifier = Modifier) {
    var theme = remember {
        mutableStateOf(false)
    }
    ThemeChangeTheme(theme.value) {
        Column {
            Text(
                text = "Hello $name!",
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier
            )
            Button(onClick = { theme.value = !theme.value }) {
                Text(text = "Theme Change")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThemeChangeTheme {
        App("Android")
    }
}