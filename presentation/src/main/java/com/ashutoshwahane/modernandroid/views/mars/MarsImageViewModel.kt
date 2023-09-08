package com.ashutoshwahane.modernandroid.views.mars

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import dev.ashutoshwahane.domain.usecase.mars_image.GetMarsImageUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsImageViewModel @Inject constructor(private val getMarsImageUseCase: GetMarsImageUseCase)
    : ViewModel() {

    val marImageList: MutableState<List<MarsImageModel>> by lazy {
        mutableStateOf(emptyList())
    }

    fun getMarsImages() {
        viewModelScope.launch {
            val response = getMarsImageUseCase.invoke()
            Log.d("alien", "mars image list: ${response.listIterator()}")
            marImageList.value = response
        }
    }

}