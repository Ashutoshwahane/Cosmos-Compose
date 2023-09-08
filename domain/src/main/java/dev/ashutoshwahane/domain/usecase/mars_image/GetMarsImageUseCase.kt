package dev.ashutoshwahane.domain.usecase.mars_image

import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import dev.ashutoshwahane.domain.repository.ImageRepository
import javax.inject.Inject

class GetMarsImageUseCase @Inject constructor(
    val repository: ImageRepository
) {
    suspend fun invoke():List<MarsImageModel>{
        return repository.getMarsImage()
    }
}