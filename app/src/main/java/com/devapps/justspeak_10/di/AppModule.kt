package com.devapps.justspeak_10.di

import android.app.Application
import android.content.Context
import com.devapps.justspeak_10.JustSpeakApplication
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
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
}