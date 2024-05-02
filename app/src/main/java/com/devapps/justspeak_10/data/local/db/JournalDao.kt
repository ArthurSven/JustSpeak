package com.devapps.justspeak_10.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.devapps.justspeak_10.data.local.model.Journal
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {

 abstract fun journalEntryDao() : JournalEntryDao
@Query("SELECT * FROM journal WHERE author = :username ORDER BY date_created DESC")
 suspend fun getMyJournals(username: String) : Flow<List<Journal>>

 @Query("SELECT * FROM journal ORDER BY date_created DESC")
 suspend fun getAllJournals() : Flow<List<Journal>>

 @Insert
 suspend fun createJournal(journal: Journal)

 @Update
 suspend fun editJournal(journal: Journal)

 @Query("DELETE FROM journal WHERE journalId = :journalId")
 suspend fun deleteJournalById(journalId: Int)

 // Method to delete journal and its associated entries
 @Transaction
 suspend fun deleteJournalWithEntries(journal: Journal) {
  val entriesExist = journalEntryDao().getJournalContent(journal.journalId)

  if (entriesExist != null) {
   journalEntryDao().deleteJournalEntriesByJournalId(journal.journalId)
  }

  deleteJournalById(journal.journalId)
 }

}