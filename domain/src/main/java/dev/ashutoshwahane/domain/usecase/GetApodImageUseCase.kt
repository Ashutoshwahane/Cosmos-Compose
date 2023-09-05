package dev.ashutoshwahane.domain.usecase

import dev.ashutoshwahane.domain.model.ImageModel
import dev.ashutoshwahane.domain.repository.ImageRepository
import javax.inject.Inject

class GetApodImageUseCase @Inject constructor (
    private val repository: ImageRepository
){
    suspend operator fun invoke(): ImageModel {
       return repository.getApodImage()
    }
}
