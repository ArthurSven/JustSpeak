package com.devapps.justspeak_10.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "flashcards")
data class FlashcardLocal(
    @PrimaryKey(autoGenerate = true)
    val flashcardId : Int = 0,
    @ColumnInfo(name = "german_translation")
    val germanTranslation: String,
    @ColumnInfo(name = "english_translation")
    val englishTranslation: String,
    @ColumnInfo("creator")
    val creator: String,
    @ColumnInfo("date_created")
    val dateCreated: String,
    @ColumnInfo(name = "is_synced")
    var isSynced: Boolean = false,
    @ColumnInfo(name = "remote_id")
    var remoteId: String? = null
)

@Serializable
data class FlashcardNetwork(
    val germanTranslation: String,
    val englishTranslation: String,
    val creator: String,
    val dateCreated: String
)