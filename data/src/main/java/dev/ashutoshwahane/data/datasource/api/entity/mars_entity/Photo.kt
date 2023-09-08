package dev.ashutoshwahane.data.datasource.api.entity.mars_entity

data class Photo(
    val camera: Camera,
    val earth_date: String,
    val id: Int,
    val img_src: String,
    val rover: Rover,
    val sol: Int
)