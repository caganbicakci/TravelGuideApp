package com.caganbicakci.travelguideapp.di

import android.content.Context
import com.caganbicakci.travelguideapp.data.localdb.AppDatabase
import com.caganbicakci.travelguideapp.data.localdb.TripPlanDao
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideTripModelDao(appDatabase: AppDatabase): TripPlanDao {
        return appDatabase.tripPlanDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(appContext)
    }

    @Provides
    fun provideEntity() = TripPlanModel()
}