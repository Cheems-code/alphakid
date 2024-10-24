package com.example.alphakid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WordFormationGame(word: String, currentIndex: Int, onRecognized: (Boolean) -> Unit) {
    var recognizedLetter by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            for (i in word.indices) {
                val color = if (i < currentIndex) Color.Green else Color.Gray
                Text(text = word[i].toString(), color = color, style = MaterialTheme.typography.headlineSmall)
            }
        }

        Button(onClick = { /* Trigger the camera capture and recognition */ }) {
            Text("Tomar foto")
        }

        // Mostrar resultado
        if (recognizedLetter.isNotEmpty()) {
            if (recognizedLetter == word[currentIndex].toString()) {
                Text("¡Correcto!", color = Color.Green)
                onRecognized(true)
            } else {
                Text("Incorrecto, intenta de nuevo", color = Color.Red)
                onRecognized(false)
            }
        }
    }
}

@Preview
@Composable
fun PreviewWordFormationGame() {
    WordFormationGame(word = "KID", currentIndex = 0, onRecognized = {})
}