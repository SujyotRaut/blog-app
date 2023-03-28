package com.example.blogapp.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private var _searchText = mutableStateOf("")

    val searchText: String
        get() = _searchText.value

    fun onChangeSearchText(text: String) {
        _searchText.value = text
    }
}