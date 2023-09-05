package dev.ashutoshwahane.domain.repository

import dev.ashutoshwahane.domain.model.ImageModel

interface ImageRepository {
    suspend fun getApodImage(): ImageModel
}