package com.devapps.justspeak_10.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.devapps.justspeak_10.data.local.model.Journal
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {

@Query("SELECT * FROM journal WHERE author = :username ORDER BY date_created DESC")
 fun getMyJournals(username: String) : Flow<List<Journal>>

 @Insert
 suspend fun createJournal(journal: Journal)

 @Update
 suspend fun editJournal(journal: Journal)

 @Delete
 suspend fun deleteJournal(journal: Journal) 

}