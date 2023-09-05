package dev.ashutoshwahane.data.repository

import dev.ashutoshwahane.data.datasource.api.services.ImageApi
import dev.ashutoshwahane.data.mapper.ToModel
import dev.ashutoshwahane.domain.model.ImageModel
import dev.ashutoshwahane.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: ImageApi
): ImageRepository {
    override suspend fun getApodImage(): ImageModel {
        return api.getApodImage("DEMO_KEY").ToModel()
    }
}
