package dev.ashutoshwahane.data.mapper.mars

import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import entity.Photo


fun Photo.toModel(): MarsImageModel {
    return MarsImageModel(
        earth_date = earth_date,
        id = id,
        img_src = img_src,
        sol = sol,
        cameraFullName = camera.full_name,
        cameraName = camera.name,
        rovStatus = rover.status,
        totalImages = rover.total_photos
    )
}