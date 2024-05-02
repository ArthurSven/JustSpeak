package com.devapps.justspeak_10.utils

import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import com.devapps.justspeak_10.data.local.model.Journal

data class InsertFlashcardState(
    val isSuccessful: Boolean = false,
    val error: String? = null
)

data class InsertFlashcardResult(
    val data: FlashcardLocal,
    val errorMessage: String?
)

data class InsertJournalState(
    val isSuccessful: Boolean = false,
    val error: String? = null
)

data class InsertJournalResult(
    val data: Journal,
    val errorMessage: String?
)

sealed class Response {
    class Success(val response: Any) : Response()
    class Error(val error: Exception) : Response()
}