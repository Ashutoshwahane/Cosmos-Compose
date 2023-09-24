package dev.ashutoshwahane.domain.usecase

import android.util.Log
import dev.ashutoshwahane.domain.model.ImageModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.lang.NullPointerException

class GetApodImageUseCaseTest{
    private lateinit var getImageUsecase: GetApodImageUseCase
    private lateinit var fakeImageRepository: FakeImageRepository

    @Before
    fun setUpUseCase() {
        fakeImageRepository = FakeImageRepository()
        getImageUsecase = GetApodImageUseCase(repository = fakeImageRepository)

        runBlocking {
            val fakeResponse = getImageUsecase.invoke()
            displayResponse(fakeResponse)
        }
    }

    fun displayResponse(imageModel: ImageModel){
       println("imageModel : $imageModel")
    }


    @Test
    fun checkIfTheResponseIsNullOrNot(): Unit = runBlocking {
        val response = getImageUsecase.invoke()
        if (response == null){
            assertThrows(
                NullPointerException::class.java
            ) {
                println("Null pointer exception")
            }
        }else {
            println("test case passed")
        }
    }
}