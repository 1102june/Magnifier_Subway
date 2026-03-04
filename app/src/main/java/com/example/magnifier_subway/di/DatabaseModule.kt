package com.example.magnifier_subway.di
//Room DB 설정

import android.content.Context
import androidx.room.Room
import com.example.magnifier_subway.data.SubwayDatabase
import com.example.magnifier_subway.data.dao.StationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SubwayDatabase {
        return Room.databaseBuilder(
            context,
            SubwayDatabase::class.java,
            "subway_magnifier_db"
        ).build()
    }

    @Provides
    fun provideStationDao(database: SubwayDatabase): StationDao {
        return database.stationDao()
    }
}