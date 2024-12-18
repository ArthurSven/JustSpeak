package com.devapps.justspeak_10.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devapps.justspeak_10.data.local.Repository.OfflineFlashcardRepository
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import com.devapps.justspeak_10.utils.InsertFlashcardResult
import com.devapps.justspeak_10.utils.InsertFlashcardState
import com.devapps.justspeak_10.utils.Response
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.annotation.meta.When
import javax.inject.Inject

@HiltViewModel
class FlashcardViewModel @Inject constructor(
    private val offlineFlashcardRepository: OfflineFlashcardRepository) : ViewModel() {

    private val _insertResultState = MutableStateFlow(InsertFlashcardState())
    val insertResultState = _insertResultState.asStateFlow()

        private val _userFlashcards = MutableStateFlow<List<FlashcardLocal>>(emptyList())
        val userFlashcards = _userFlashcards.asStateFlow()

        private val _createdBy = MutableStateFlow<String>("")
        val createdBy: StateFlow<String> = _createdBy

    private val _updateResultState = MutableStateFlow(InsertFlashcardState())
    val updateResultState = _updateResultState.asStateFlow()

    fun setCreatedBy(username: String) {
        _createdBy.value = username
        viewModelScope.launch {
            getAllFlashcardsByUser(username)
        }

    }


        suspend fun getAllFlashcardsByUser(username: String) {
            viewModelScope.launch {
                offlineFlashcardRepository.getAllFlashcardsByUsername(username).collect {
                    flashCards ->
                    _userFlashcards.value = flashCards
                }
            }
        }

    init {
        // Fetch flashcard data for the signed-in user when ViewModel is initialized
        viewModelScope.launch {
            getAllFlashcardsByUser(_createdBy.value)
        }

    }


    suspend fun insertFlashcard(flashcardLocal: FlashcardLocal) {
        viewModelScope.launch {
            val result = offlineFlashcardRepository.createFlashcard(flashcardLocal)
            when(result) {
                is Response.Error -> {
                    onInsertResult(
                        InsertFlashcardResult(
                            data = flashcardLocal,
                            errorMessage = result.error.message
                        )
                    )
                }
                is Response.Success -> {
                    onInsertResult(
                        InsertFlashcardResult(
                            data = flashcardLocal,
                            errorMessage = null
                        )
                    )
                }
            }
        }
    }
        fun onInsertResult(result: InsertFlashcardResult) {
            _insertResultState.update {
                it.copy(
                    isSuccessful = result.errorMessage == null,
                    error =result.errorMessage
                )
            }
        }

    fun onUpdateResult(result: InsertFlashcardResult) {
        _updateResultState.update {
            it.copy(
                isSuccessful = result.errorMessage == null,
                error =result.errorMessage
            )
        }
    }

    fun resetState() {
        _insertResultState.update {
            InsertFlashcardState()
        }
    }

    suspend fun deleteFlashcard(flashcardLocal: FlashcardLocal) {
        offlineFlashcardRepository.deleteFlashcard(flashcardLocal)
    }

    fun getFlashcardById(flashcardId: Int): Flow<FlashcardLocal?> {
        return offlineFlashcardRepository.getFlashcardById(flashcardId)
    }

    suspend fun updateFlashcard(flashcardLocal: FlashcardLocal) {

        viewModelScope.launch {
            val result = offlineFlashcardRepository.updateFlashcard(flashcardLocal)
            when(result) {
                is Response.Error -> {
                    onUpdateResult(
                        InsertFlashcardResult(
                            data = flashcardLocal,
                            errorMessage = result.error.message
                        )
                    )
                }
                is Response.Success -> {
                    onUpdateResult(
                        InsertFlashcardResult(
                            data = flashcardLocal,
                            errorMessage = null
                        )
                    )
                }
            }
        }
    }

}