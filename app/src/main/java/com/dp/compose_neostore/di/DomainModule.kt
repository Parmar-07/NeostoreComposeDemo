package com.dp.compose_neostore.di

import android.content.Context
import com.dp.compose_neostore.utils.AppCache
import com.dp.neostore_domain.base.IAppCache
import com.dp.neostore_domain.repositories.AuthenticationRepository
import com.dp.neostore_domain.usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(authenticationRepository: AuthenticationRepository): LoginUseCase {
        return LoginUseCase(authenticationRepository)
    }

    @Provides
    @Singleton
    fun provideAppCache(@ApplicationContext appContext: Context): IAppCache {
        return AppCache(appContext)
    }




}