package com.ashutoshwahane.modernandroid.views.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ashutoshwahane.domain.usecase.GetApodImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ashutoshwahane.domain.model.ImageModel
import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import dev.ashutoshwahane.domain.resource.Resource
import dev.ashutoshwahane.domain.usecase.mars_image.GetMarsImageUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getApodImageUsecase: GetApodImageUseCase,
    private val getMarsImageUseCase: GetMarsImageUseCase
): ViewModel() {

    val _data: MutableLiveData<ImageModel> = MutableLiveData()
    val marImageList: MutableState<List<MarsImageModel>> by lazy {
        mutableStateOf(emptyList())
    }

    fun getApodImage(){
        viewModelScope.launch {
            val response = getApodImageUsecase.invoke()
            val title = response.imageTitle
            _data.value = response
            Log.d("debug", "response : $title")
        }
    }

    fun getMarsImages() {
        viewModelScope.launch {
           val response = getMarsImageUseCase.invoke()
            marImageList.value = response
        }
    }
}