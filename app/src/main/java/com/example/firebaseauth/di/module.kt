package com.example.firebaseauth.di

import com.example.firebaseauth.data.firebaseAuth.AuthRepositryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object module {

    @Singleton
    @Provides
    fun providesfirebaseAuth():FirebaseAuth =FirebaseAuth.getInstance()


    @Singleton
    @Provides
    fun providesAuthRepositryImpl():AuthRepositryImpl = AuthRepositryImpl(
        providesfirebaseAuth()
    )
}