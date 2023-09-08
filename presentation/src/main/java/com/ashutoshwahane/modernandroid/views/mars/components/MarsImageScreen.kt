package com.ashutoshwahane.modernandroid.views.mars.components

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ashutoshwahane.modernandroid.views.mars.MarsImageViewModel
import dev.ashutoshwahane.domain.model.mars.MarsImageModel

@Composable
fun MarsImageScreen(marsImageViewModel:MarsImageViewModel) {
    val imageList = marsImageViewModel.marImageList.value

    LazyColumn(){
        items(imageList){
            AsyncImage(model = it.img_src, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp)
                )
            Log.d("alien","ImageId ${it.id}: ${it.img_src}")
        }
    }





}