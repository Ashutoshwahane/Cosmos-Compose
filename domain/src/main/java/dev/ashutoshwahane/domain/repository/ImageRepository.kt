package dev.ashutoshwahane.domain.repository

import dev.ashutoshwahane.domain.model.ImageModel
import dev.ashutoshwahane.domain.model.mars.MarsImageModel

interface ImageRepository {
    suspend fun getApodImage(): ImageModel

    suspend fun getMarsImage():List<MarsImageModel>

}