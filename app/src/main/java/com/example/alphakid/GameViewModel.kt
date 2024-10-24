package com.example.alphakid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val _currentLetter = MutableStateFlow('A')
    val currentLetter: StateFlow<Char> = _currentLetter

    private val _currentWord = MutableStateFlow("KID")
    val currentWord: StateFlow<String> = _currentWord

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

    fun nextLetter() {
        // Lógica para avanzar a la siguiente letra
        viewModelScope.launch {
            _currentLetter.value = _currentLetter.value + 1
        }
    }

    fun nextWord() {
        viewModelScope.launch {
            // Lógica para avanzar a la siguiente palabra
            _currentWord.value = "NEWWORD"
            _currentIndex.value = 0
        }
    }

    fun updateIndex(newIndex: Int) {
        _currentIndex.value = newIndex
    }
}