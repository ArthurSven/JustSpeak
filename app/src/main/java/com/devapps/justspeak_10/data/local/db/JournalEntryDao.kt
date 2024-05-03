package com.devapps.justspeak_10.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.devapps.justspeak_10.data.local.model.JournalEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalEntryDao {

    @Insert
    suspend fun createJournalEntry(journalEntry: JournalEntry)

    @Query("SELECT * FROM journal_entry WHERE journal_id = :journalId ORDER BY date DESC")
     fun getJournalContent(journalId: Int) : Flow<List<JournalEntry>>

     @Delete
     suspend fun deleteJournalEntry(journalEntry: JournalEntry)

     @Update
     suspend fun updateJournalEntry(journalEntry: JournalEntry)
}