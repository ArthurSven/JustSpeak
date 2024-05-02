package com.devapps.justspeak_10.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devapps.justspeak_10.data.local.Repository.OfflineJournalRepository
import com.devapps.justspeak_10.data.local.model.Journal
import com.devapps.justspeak_10.utils.InsertJournalResult
import com.devapps.justspeak_10.utils.InsertJournalState
import com.devapps.justspeak_10.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JournalViewModel @Inject constructor(
    private val offlineJournalRepository: OfflineJournalRepository
) : ViewModel() {

    private val _insertJournalResult = MutableStateFlow(InsertJournalState())
    val insertJournalState = _insertJournalResult.asStateFlow()

    private val _myJournals = MutableStateFlow<List<Journal>>(emptyList())
    val myJournals = _myJournals.asStateFlow()

    private val _author = MutableStateFlow("")
    val author: StateFlow<String> = _author

    fun setAuthor(userId: String) {
        _author.value = userId
        viewModelScope.launch {
            getMyJournals(userId)
        }
    }

    suspend fun getMyJournals(user: String){
        viewModelScope.launch {
            offlineJournalRepository.getMyJournals(user).collect {
                myJournal ->
                _myJournals.value = myJournal
            }
        }
    }

    suspend fun insertJournal(journal: Journal) {
        viewModelScope.launch {
            val result = offlineJournalRepository.createJournal(journal)
            when(result) {
                is Response.Error -> {
                    onInsertResult(
                        InsertJournalResult(
                            data = journal,
                            errorMessage = result.error.message
                        )
                    )
                }
                is Response.Success -> {
                    onInsertResult(
                        InsertJournalResult(
                            data = journal,
                            errorMessage = null
                        )
                    )
                }
            }
        }
    }

    private fun onInsertResult(result: InsertJournalResult) {
        _insertJournalResult.update {
            it.copy(
                isSuccessful = result.errorMessage == null,
                error = result.errorMessage
            )
        }
    }

    suspend fun deleteJournalById(journalId: Int) {
        offlineJournalRepository.deleteJournalById(journalId)
    }

    suspend fun editJournal(journal: Journal) {
        offlineJournalRepository.editJournal(journal)
    }

    suspend fun getAllJournals() : Flow<List<Journal>> {
        return offlineJournalRepository.getAllJournals()
    }
}