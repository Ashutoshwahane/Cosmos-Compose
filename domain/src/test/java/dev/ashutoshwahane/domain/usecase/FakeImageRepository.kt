package dev.ashutoshwahane.domain.usecase

import dev.ashutoshwahane.domain.model.ImageModel
import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import dev.ashutoshwahane.domain.repository.ImageRepository

class FakeImageRepository : ImageRepository{
    override suspend fun getApodImage(): ImageModel {
        return ImageModel(
            imageTitle = "Test.png",
            imageDescription = "testing descreption",
            lowQualityImage = "lowImage.png",
            highQualityImage = "highQuality.png",
            mediaType = "image",
            copyRight = "ashutoshwahane",
            date = "today"
        )

    }

    override suspend fun getMarsImage(): List<MarsImageModel> {
        TODO("Not yet implemented")
    }

}