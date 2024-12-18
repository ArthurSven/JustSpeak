package com.devapps.justspeak_10

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devapps.justspeak_10.data.local.db.FlashcardDao
import com.devapps.justspeak_10.data.local.db.JustSpeakDatabase
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
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
    fun insertFlashcard() = runTest {
        val flashcard = FlashcardLocal(
            creator = "user1",
            germanTranslation = "Wie bekommt man das?",
            englishTranslation = "How does one get that?",
            isSynced = false,
            dateCreated = "03-08-2024"
        )

        flashcardDao.createFlashcard(flashcard)
//        val flashcards = flashcardDao.getFlashcardsByUsername("user1").first()
//        assertEquals(1, flashcards.size)
//        assertEquals(flashcard, flashcards[0])
    }

    @Test
    fun getFlashCard() = runTest {
        val username = "user1"
        flashcardDao.getFlashcardsByUsername(username)
    }

    @Test
    fun insertAndDeleteFlashcard() = runTest {
        val flashcard = FlashcardLocal(
            creator = "user2",
            germanTranslation = "Wie bekommt man das?",
            englishTranslation = "How does one get that?",
            isSynced = false,
            dateCreated = "03-08-2024"
        )

        flashcardDao.createFlashcard(flashcard)

        delay(5000)  // Delay for 5 seconds
        flashcardDao.deleteFlashCard(flashcard)
    }
}