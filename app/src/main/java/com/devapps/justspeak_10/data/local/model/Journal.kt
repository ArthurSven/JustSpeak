package com.devapps.justspeak_10.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "journal")
data class Journal(
    @PrimaryKey(autoGenerate = true)
    val journalId: Int = 0,
    @ColumnInfo("journal_name")
    val journalName: String,
    @ColumnInfo("date_created")
    val date: String,
    @ColumnInfo("author")
    val author: String,
    @ColumnInfo("is_synced")
    var isSynced: Boolean,
    @ColumnInfo(name = "remote_journal_id")
    var remoteJournalId: String? = null
)

@Serializable
data class JournalNetwork(
    val journalName: String,
    val date: String,
    val author: String
)

@Entity(foreignKeys = [
    ForeignKey(
        entity = Journal::class,
        parentColumns = ["journalId"],
        childColumns = ["journal_id"],
        onDelete = ForeignKey.CASCADE
    )
                      ],
    tableName = "journal_entry")
data class JournalEntry(
    @PrimaryKey(autoGenerate = true)
    val journalEntryId: Int = 0,
    @ColumnInfo("entry")
    val entry: String,
    @ColumnInfo("date")
    val date: String,
    @ColumnInfo("author")
    val author: String,
    @ColumnInfo("journal_id")
    val journalId: Int,
    @ColumnInfo("is_synced")
    val isSynced: Boolean
)

@Serializable
data class JournalEntryNetwork(
    val entry: String,
    val date: String,
    val author: String,
    val journalId: Int
)
