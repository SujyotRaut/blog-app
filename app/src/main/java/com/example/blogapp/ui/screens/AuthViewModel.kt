package com.example.blogapp.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    private var _username = mutableStateOf("")
    private var _password = mutableStateOf("")

    val username: String
        get() = _username.value

    val password: String
        get() = _password.value

    fun onChangeUsername(text: String) {
        _username.value = text
    }

    fun onChangePassword(text: String) {
        _password.value = text
    }
}