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

    suspend fun deleteJournalById(journalId: Int)

    suspend fun deleteJournalWithEntries(journal: Journal)
}

class OfflineJournalRepositoryImpl @Inject constructor(
    private val journalDao: JournalDao,
    firestore: FirebaseFirestore
) : OfflineJournalRepository {

    private val journalCollection = firestore.collection("journals")
    override suspend fun getMyJournals(username: String): Flow<List<Journal>> {
        return journalDao.getMyJournals(username)
    }

    override suspend fun getAllJournals(): Flow<List<Journal>> {
        return journalDao.getAllJournals()
    }

    override suspend fun createJournal(journal: Journal) : Response {
        return try {
            val documentRef = journalCollection.add(journal.toJournalNetwork()).await()

            journal.remoteJournalId = documentRef.id
            journal.isSynced = true
            val success = journalDao.createJournal(journal)
            Response.Success(success)
        } catch (e: Exception) {
            return Response.Error(e)
        }
    }

    override suspend fun editJournal(journal: Journal) {
        journalDao.editJournal(journal)
    }

    override suspend fun deleteJournalById(journalId: Int) {
        journalDao.deleteJournalById(journalId)
    }

    override suspend fun deleteJournalWithEntries(journal: Journal) {
        journalDao.deleteJournalWithEntries(journal)
    }

    private fun Journal.toJournalNetwork() : Map<String, Any> {
        return mapOf(
            "journal name" to journalName,
            "author" to author,
            "created date" to date
        )
    }

}