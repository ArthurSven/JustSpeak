package com.devapps.justspeak_10.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devapps.justspeak_10.data.local.model.FlashcardLocal

@Database(entities = [FlashcardLocal::class], version = 1, exportSchema = false)
abstract class JustSpeakDatabase : RoomDatabase() {

    abstract fun flashcardDao() : FlashcardDao
}