package com.caganbicakci.travelguideapp.di

import com.caganbicakci.travelguideapp.data.ApiService
import com.caganbicakci.travelguideapp.data.remote.repository.TravelRepositoryImp
import com.caganbicakci.travelguideapp.domain.repository.TravelRepository
import com.caganbicakci.travelguideapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDestinationRepository(apiService: ApiService): TravelRepository {
        return TravelRepositoryImp(apiService)
    }
}