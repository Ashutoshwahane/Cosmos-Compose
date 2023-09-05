package dev.ashutoshwahane.data.datasource.api.services

import dev.ashutoshwahane.data.datasource.api.entity.ImageEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {

    @GET("planetary/apod")
    suspend fun getApodImage(
        @Query("api_key") key: String
    ): ImageEntity

}
