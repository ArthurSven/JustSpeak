package com.devapps.justspeak_10.utils

import com.devapps.justspeak_10.data.local.model.FlashcardLocal

data class InsertFlashcardState(
    val isSuccessful: Boolean = false,
    val error: String? = null
)

data class InsertFlashcardResult(
    val data: FlashcardLocal,
    val errorMessage: String?
)

sealed class Response {
    class Success(val response: Any) : Response()
    class Error(val error: Exception) : Response()
}