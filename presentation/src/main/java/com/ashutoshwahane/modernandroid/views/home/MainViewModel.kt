package com.ashutoshwahane.modernandroid.views.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ashutoshwahane.domain.usecase.GetApodImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getApodImageUsecase: GetApodImageUseCase
): ViewModel() {


    fun getApodImage(){
        viewModelScope.launch {
            val response = getApodImageUsecase.invoke()
            val title = response.imageTitle
            Log.d("debug", "response : $title")
        }
    }
}