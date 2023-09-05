package com.ashutoshwahane.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.ashutoshwahane.data.datasource.api.RetrofitInstance
import dev.ashutoshwahane.data.datasource.api.services.ImageApi
import dev.ashutoshwahane.data.repository.ImageRepositoryImpl
import dev.ashutoshwahane.domain.repository.ImageRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ImageModule {

    @Provides
    @Singleton
    fun provideImageApi(): ImageApi {
        return RetrofitInstance.getRetrofitInstance().create(ImageApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImageRepository(repositoryImpl: ImageRepositoryImpl): ImageRepository {
        return repositoryImpl
    }


}
