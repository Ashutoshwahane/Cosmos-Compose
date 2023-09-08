package dev.ashutoshwahane.domain.usecase.mars_image

import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import dev.ashutoshwahane.domain.repository.ImageRepository
import dev.ashutoshwahane.domain.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetMarsImageUseCase @Inject constructor(
    val repository: ImageRepository
) {
    suspend operator fun  invoke(): Flow<Resource<List<MarsImageModel>>> = flow {
        try {
            emit(Resource.Loading())
            val marsImageList = repository.getMarsImage()
            emit(Resource.Success(marsImageList))
        }catch (e:IOException){
            emit(Resource.Error("Couldn't reach server check your internet connection"))
        }
    }
}