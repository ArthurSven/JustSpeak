package com.devapps.justspeak_10.data.local.Repository

import com.devapps.justspeak_10.data.local.db.JournalDao
import com.devapps.justspeak_10.data.local.model.Journal
import com.devapps.justspeak_10.utils.Response
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

interface OfflineJournalRepository {

    suspend fun getMyJournals(username: String) : Flow<List<Journal>>

    suspend fun getAllJournals() : Flow<List<Journal>>

    suspend fun createJournal(journal: Journal) : Response

    suspend fun editJournal(journal: Journal)

    suspend fun deleteJournal(journal: Journal)

}

class OfflineJournalRepositoryImpl @Inject constructor(
    private val journalDao: JournalDao,
) : OfflineJournalRepository {

    override suspend fun getMyJournals(username: String): Flow<List<Journal>> {
        return journalDao.getMyJournals(username)
    }

    override suspend fun getAllJournals(): Flow<List<Journal>> {
        return journalDao.getAllJournals()
    }

    override suspend fun createJournal(journal: Journal) : Response {
        return try {
            val success = journalDao.createJournal(journal)
            Response.Success(success)
        } catch (e: Exception) {
            return Response.Error(e)
        }
    }

    override suspend fun editJournal(journal: Journal) {
        journalDao.editJournal(journal)
    }

    override suspend fun deleteJournal(journal: Journal) {
        return journalDao.deleteJournal(journal)
    }

    private fun Journal.toJournalNetwork() : Map<String, Any> {
        return mapOf(
            "journal name" to journalName,
            "author" to author,
            "created date" to date
        )
    }

}