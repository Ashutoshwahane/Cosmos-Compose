package dev.ashutoshwahane.domain.model.mars

data class MarsImageModel(
    val earth_date: String? = "",
    val id: Int? = 0,
    val img_src: String? = "",
    val sol: Int? = 0,
    val cameraFullName: String? = "",
    val cameraName: String? = "",
    val rovStatus:String? = "",
    val totalImages: Int? = 0,
    val error:String? = "",
    val isLoading:Boolean?= false
)
