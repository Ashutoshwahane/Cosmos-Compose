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
    val isLoading:Boolean?= false,
    var rover: RoverModel? = null
)

data class RoverModel(
    val cameras: List<CameraX>,
    val id: Int,
    val landing_date: String,
    val launch_date: String,
    val max_date: String,
    val max_sol: Int,
    val name: String,
    val status: String,
    val total_photos: Int
)

data class CameraX(

    val full_name: String,
    val name: String
)
