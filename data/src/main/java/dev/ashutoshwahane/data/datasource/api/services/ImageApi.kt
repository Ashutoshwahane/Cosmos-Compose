package dev.ashutoshwahane.data.datasource.api.services

import dev.ashutoshwahane.data.datasource.api.entity.ImageEntity
import dev.ashutoshwahane.data.datasource.api.entity.mars_entity.MarsImageEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {

    @GET("planetary/apod")
    suspend fun getApodImage(
        @Query("api_key") key: String
    ): ImageEntity


    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=100")
    suspend fun getMarsImage(@Query("api_key") key: String):MarsImageEntity








}
