package com.dp.compose_neostore.di

import com.dp.neostore_data.repositories.AuthenticationRepository
import com.dp.neostore_data.source.apis.NeoStoreApis
import com.dp.nestore_domain.repositories.IAuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

/*    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl():String{
        return ""
    }

    @Provides
    @Singleton
    @Named("extra")
    fun provideExtra():String{
        return ""
    }

    @Provides
    @Singleton
    fun provideNeoStoreApi(@Named("baseUrl") baseUrl : String,@Named("extra") extra:String): NeoStoreApis {
        return NeoStoreApis.invoke(baseUrl)
    }*/

    @Provides
    @Singleton
    fun provideNeoStoreApi(): NeoStoreApis {
        return NeoStoreApis.invoke("")
    }

    @Provides
    @Singleton
    fun provideAuthRepo(neoStoreApis: NeoStoreApis): IAuthenticationRepository {
        return AuthenticationRepository(neoStoreApis)
    }


}