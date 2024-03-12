package com.devapps.justspeak_10.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devapps.justspeak_10.data.local.Repository.OfflineFlashcardRepository
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import com.devapps.justspeak_10.utils.InsertFlashcardResult
import com.devapps.justspeak_10.utils.InsertFlashcardState
import com.devapps.justspeak_10.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
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

        suspend fun getAllFlashcardsByUser(username: String) {
            viewModelScope.launch {
                offlineFlashcardRepository.getAllFlashcardsByUsername(username).collect {
                    flashCards ->
                    _userFlashcards.value = flashCards
                }
            }
        }

        suspend fun insertFlashcard(flashcardLocal: FlashcardLocal) : Response {
            val result = offlineFlashcardRepository.createFlashcard(flashcardLocal)

            When(result)  {
                is Response.Error -> {
                  onInsertResult(InsertFlashcardResult(
                      data = flashcardLocal,
                      errorMessage = result
                  ))
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

}