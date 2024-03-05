package com.devapps.justspeak_10.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.devapps.justspeak_10.JustSpeakApplication
import com.devapps.justspeak_10.data.local.Repository.OfflineFlashcardRepository
import com.devapps.justspeak_10.data.local.Repository.OfflineflashcardRepositoryImpl
import com.devapps.justspeak_10.data.local.db.FlashcardDao
import com.devapps.justspeak_10.data.local.db.JustSpeakDatabase
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJustSpeakApplication() : JustSpeakApplication {
        return JustSpeakApplication()
    }

    @Provides
    @Singleton
    fun provideSignInClient(application: Application) : SignInClient {
        return Identity.getSignInClient(application)
    }

    @Provides
    @Singleton
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideJustSpeakDatabase(app: Application) : JustSpeakDatabase {
        return Room.databaseBuilder(
            app,
            JustSpeakDatabase::class.java,
            "just_speak_db"
        ).build()
    }


    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFlashcardRepository(
        flashcardDao: FlashcardDao,
        firestore: FirebaseFirestore
    ): OfflineFlashcardRepository {
        return OfflineflashcardRepositoryImpl(flashcardDao, firestore)
    }
}