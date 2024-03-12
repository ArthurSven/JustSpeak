package com.devapps.justspeak_10.data.local.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface FlashcardDao {

    @Query("SELECT * FROM flashcards WHERE creator = :username ORDER BY date_created DESC")
    suspend fun getFlashcardsByUsername(username: String) : Flow<List<FlashcardLocal>>

    @Query("SELECT * FROM flashcards WHERE is_synced = false ORDER BY date_created")
    suspend fun getUnsyncedFlashcards() : List<FlashcardLocal>

    @Insert
    suspend fun createFlashcard(flashcardLocal: FlashcardLocal)

    @Delete
    suspend fun deleteFlashCard(flashcardLocal: FlashcardLocal)

}

@Database(entities = [FlashcardLocal::class], version = 1, exportSchema = false)
abstract class JustSpeakDatabase : RoomDatabase() {

    abstract fun flashcardDao() : FlashcardDao
}