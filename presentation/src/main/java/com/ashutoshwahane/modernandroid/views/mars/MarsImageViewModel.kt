package com.ashutoshwahane.modernandroid.views.mars

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import dev.ashutoshwahane.domain.resource.Resource
import dev.ashutoshwahane.domain.usecase.mars_image.GetMarsImageUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.http.HTTP
import javax.inject.Inject

@HiltViewModel
class MarsImageViewModel @Inject constructor(private val getMarsImageUseCase: GetMarsImageUseCase) :
    ViewModel() {

    val marImageList: MutableState<List<MarsImageModel>> by lazy {
        mutableStateOf(emptyList())
    }

    suspend fun getMarsImages() {
            getMarsImageUseCase().onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        marImageList.value = listOf(MarsImageModel(error = result.message ?: "An unexpected error occurred"))
                        Log.d("MarsImageViewModel","Error ${result.message}")
                    }

                    is Resource.Loading -> {
                        marImageList.value = listOf(MarsImageModel(isLoading = true))
                        Log.d("MarsImageViewModel","Is Loading()")
                    }

                    is Resource.Success -> {
                        val response = result.data
                        Log.d("alien", "mars image list: ${response?.listIterator()}")
                        marImageList.value = result.data!!
                    }
                }

            }.launchIn(viewModelScope)



    }
}