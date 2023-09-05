package dev.ashutoshwahane.domain.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.ashutoshwahane.domain.repository.ImageRepository
import dev.ashutoshwahane.domain.usecase.GetApodImageUseCase
import javax.inject.Singleton


/*@Module
@InstallIn(SingletonComponent::class)
class ImageDomainModule {



    @Provides
    @Singleton
    fun provideImageRepository(
        repository: ImageRepository
    ): GetApodImageUseCase {
        return GetApodImageUseCase(
            repository = repository
        )
    }

}*/
