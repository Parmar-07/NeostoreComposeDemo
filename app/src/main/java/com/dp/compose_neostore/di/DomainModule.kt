package com.dp.compose_neostore.di

import com.dp.nestore_domain.repositories.IAuthenticationRepository
import com.dp.nestore_domain.usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(authenticationRepository: IAuthenticationRepository): LoginUseCase {
        return LoginUseCase(authenticationRepository)
    }
}