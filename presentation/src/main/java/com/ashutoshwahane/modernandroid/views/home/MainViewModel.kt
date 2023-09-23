package com.ashutoshwahane.modernandroid.views.home

import android.util.Log
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ashutoshwahane.domain.usecase.GetApodImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ashutoshwahane.domain.model.ImageModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getApodImageUsecase: GetApodImageUseCase
): ViewModel() {

    val _data: MutableLiveData<ImageModel> = MutableLiveData()

    fun getApodImage(){
        viewModelScope.launch {
            val response = getApodImageUsecase.invoke()
            val title = response.imageTitle
            _data.value = response
            Log.d("debug", "response : $title")
        }
    }
}