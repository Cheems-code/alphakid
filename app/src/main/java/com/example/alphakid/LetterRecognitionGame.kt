package com.example.alphakid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
fun LetterRecognitionGame(currentLetter: Char, onRecognized: (Boolean) -> Unit) {
    var recognizedLetter by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Convertimos el currentLetter (Char) a String antes de pasarlo al Text
        Text(text = "Busca la letra: ${currentLetter.toString()}", style = MaterialTheme.typography.headlineSmall)

        Button(onClick = { /* Trigger the camera capture and recognition */ }) {
            Text("Tomar foto")
        }

        // Mostrar resultado
        if (recognizedLetter.isNotEmpty()) {
            if (recognizedLetter == currentLetter.toString()) {
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
fun PreviewLetterRecognitionGame() {
    LetterRecognitionGame(currentLetter = 'A', onRecognized = {})
}
