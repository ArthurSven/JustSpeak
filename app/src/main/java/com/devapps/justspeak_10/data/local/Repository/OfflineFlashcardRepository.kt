package com.devapps.justspeak_10.data.local.Repository

import com.devapps.justspeak_10.data.local.db.FlashcardDao
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

interface OfflineFlashcardRepository {

    suspend fun getAllFlashcardsByUsername(username: String) : List<FlashcardLocal>

    suspend fun createFlaschard(flashcardLocal: FlashcardLocal)

    suspend fun deleteFlashcard(flashcardLocal: FlashcardLocal)
}

class OfflineflashcardRepositoryImpl @Inject constructor(
    private val flashcardDao: FlashcardDao,
    private val firestore: FirebaseFirestore
) : OfflineFlashcardRepository {
    override suspend fun getAllFlashcardsByUsername(username: String): List<FlashcardLocal> {
        TODO("Not yet implemented")
    }

    override suspend fun createFlaschard(flashcardLocal: FlashcardLocal) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFlashcard(flashcardLocal: FlashcardLocal) {
        TODO("Not yet implemented")
    }


}