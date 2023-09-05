package dev.ashutoshwahane.data.mapper

import dev.ashutoshwahane.data.datasource.api.entity.ImageEntity
import dev.ashutoshwahane.domain.model.ImageModel


fun ImageEntity.ToModel(): ImageModel {
    return ImageModel(
        date = this.date,
        copyRight = this.copyright,
        highQualityImage = this.hdurl,
        imageDescription = this.explanation,
        imageTitle = this.title,
        lowQualityImage = this.url,
        mediaType = this.media_type
    )
}
