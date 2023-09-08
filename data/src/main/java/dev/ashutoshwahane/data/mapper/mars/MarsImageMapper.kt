package dev.ashutoshwahane.data.mapper.mars

import dev.ashutoshwahane.data.datasource.api.entity.mars_entity.Photo
import dev.ashutoshwahane.domain.model.mars.MarsImageModel


fun Photo.toModel():MarsImageModel{
    return MarsImageModel(
        earth_date = earth_date,
        id = id,
        img_src = img_src,
        sol = sol
    )
}