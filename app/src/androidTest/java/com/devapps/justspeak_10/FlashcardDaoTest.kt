package com.devapps.justspeak_10

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devapps.justspeak_10.data.local.db.FlashcardDao
import com.devapps.justspeak_10.data.local.db.JustSpeakDatabase
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalCoroutinesApi::class)
class FlashcardDaoTest {

    private lateinit var database: JustSpeakDatabase
    private lateinit var flashcardDao: FlashcardDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            JustSpeakDatabase::class.java
        ).allowMainThreadQueries().build()
        flashcardDao = database.flashcardDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertAndGetFlashcardsByUsername() = runTest {
        val flashcard = FlashcardLocal(
            creator = "user1",
            germanTranslation = "Wie bekommt man das?",
            englishTranslation = "How does one get that?",
            isSynced = true,
            dateCreated = "03-08-2024"
        )

        flashcardDao.createFlashcard(flashcard)

        val flashcards = flashcardDao.getFlashcardsByUsername("user1").first()
        assertEquals(1, flashcards.size)
        assertEquals(flashcard, flashcards[0])
    }

    @Test
    fun insertAndDeleteFlashcard() = runTest {
        val flashcard = FlashcardLocal(
            creator = "user2",
            germanTranslation = "Wie bekommt man das?",
            englishTranslation = "How does one get that?",
            isSynced = true,
            dateCreated = "03-08-2024"
        )

        flashcardDao.createFlashcard(flashcard)

        val flashcards = flashcardDao.getFlashcardsByUsername("user1").first()
        assertEquals(1, flashcards.size)
        val retrievedFlashcard = flashcards[0]

        assertEquals(flashcard.germanTranslation, retrievedFlashcard.germanTranslation)
        assertEquals(flashcard.englishTranslation, retrievedFlashcard.englishTranslation)
        assertEquals(flashcard.creator, retrievedFlashcard.creator)
        assertEquals(flashcard.dateCreated, retrievedFlashcard.dateCreated)
        assertEquals(flashcard.isSynced, retrievedFlashcard.isSynced)
        assertEquals(flashcard.remoteId, retrievedFlashcard.remoteId)
    }
}