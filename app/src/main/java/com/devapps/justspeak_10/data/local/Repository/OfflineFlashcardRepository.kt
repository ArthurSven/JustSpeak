package com.devapps.justspeak_10.data.local.Repository

import com.devapps.justspeak_10.data.local.db.FlashcardDao
import com.devapps.justspeak_10.data.local.model.FlashcardLocal
import com.devapps.justspeak_10.utils.Response
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

interface OfflineFlashcardRepository {

    suspend fun getAllFlashcardsByUsername(username: String) : Flow<List<FlashcardLocal>>

    suspend fun getUnSyncedFlashcards() : List<FlashcardLocal>

    suspend fun createFlashcard(flashcardLocal: FlashcardLocal) : Response

    suspend fun deleteFlashcard(flashcardLocal: FlashcardLocal)

    suspend fun syncUnsyncedFlashcards()
}

class OfflineflashcardRepositoryImpl @Inject constructor(
    private val flashcardDao: FlashcardDao,
    private val firestore: FirebaseFirestore
) : OfflineFlashcardRepository {

    private val flashcardCollection = firestore.collection("flashcards")


    override suspend fun getAllFlashcardsByUsername(username: String): Flow<List<FlashcardLocal>> {
        return flashcardDao.getFlashcardsByUsername(username)
    }

    override suspend fun getUnSyncedFlashcards(): List<FlashcardLocal> {
        return flashcardDao.getUnsyncedFlashcards()
    }

    override suspend fun createFlashcard(flashcardLocal: FlashcardLocal) : Response {


        return try {
            val docReference = flashcardCollection.add(flashcardLocal.toFlashCardNetwork()).await()
            // Update the local flashcard with the remote ID and mark as synced
            flashcardLocal.remoteId = docReference.id
            flashcardLocal.isSynced = true
            val success = flashcardDao.createFlashcard(flashcardLocal)
            Response.Success(success)
        } catch (e: Exception) {
            return Response.Error(e)
        }
    }

    override suspend fun deleteFlashcard(flashcardLocal: FlashcardLocal) {
        flashcardDao.deleteFlashCard(flashcardLocal)
    }

    override suspend fun syncUnsyncedFlashcards() {
        val unsyncedFlashcards = flashcardDao.getUnsyncedFlashcards()

        unsyncedFlashcards.forEach {unsyncedFlashcard ->
            try {
                val docReference = flashcardCollection.add(unsyncedFlashcard.toFlashCardNetwork()).await()

                // Update the local flashcard with the remote ID and mark as synced
                unsyncedFlashcard.remoteId = docReference.id
                unsyncedFlashcard.isSynced = true
                flashcardDao.createFlashcard(unsyncedFlashcard)
            } catch (e: Exception) {
                // Handle synchronization failure, e.g., log an error
                // You might want to implement retry or error handling based on your app's requirements
                e.printStackTrace()
            }
        }
    }

    private fun FlashcardLocal.toFlashCardNetwork() : Map<String, Any> {
        return mapOf(
            "german translation" to germanTranslation,
            "english translation" to englishTranslation,
            "creator" to creator,
            "dtae created" to dateCreated
        )
    }


}