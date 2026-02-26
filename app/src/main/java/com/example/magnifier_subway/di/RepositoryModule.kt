package com.example.magnifier_subway.di

import com.example.magnifier_subway.data.respository.AuthRepositoryImpl
import com.example.magnifier_subway.domain.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Interface
// auth Repository, auth Repository Binding
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds  //내부 인터페이스 연결  @Binds 활용
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}