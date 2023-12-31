package dev.ashutoshwahane.data.repository

import android.net.http.HttpException
import dev.ashutoshwahane.data.BuildConfig
import dev.ashutoshwahane.data.datasource.api.entity.mars_entity.Photo
import dev.ashutoshwahane.data.datasource.api.services.ImageApi
import dev.ashutoshwahane.data.mapper.ToModel
import dev.ashutoshwahane.data.mapper.mars.toModel
import dev.ashutoshwahane.domain.model.ImageModel
import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import dev.ashutoshwahane.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: ImageApi
) : ImageRepository {
    override suspend fun getApodImage(): ImageModel {
        return api.getApodImage(BuildConfig.API_KEY).ToModel()
    }


    override suspend fun getMarsImage(): List<MarsImageModel> {
        return api.getMarsImage(BuildConfig.API_KEY).photos.map { it.toModel() }
    }

}
