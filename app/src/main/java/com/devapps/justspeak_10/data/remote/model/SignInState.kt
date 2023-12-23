package com.devapps.justspeak_10.data.remote.model

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)