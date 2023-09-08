package com.ashutoshwahane.modernandroid.views.mars.components

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ashutoshwahane.modernandroid.views.mars.MarsImageViewModel
import dev.ashutoshwahane.domain.model.mars.MarsImageModel

@Composable
fun MarsImageScreen(marsImageViewModel: MarsImageViewModel,context: Context) {
    val imageList = marsImageViewModel.marImageList.value

    DisplayMarsImages(marsList = imageList,context)

}

@Composable
private fun DisplayMarsImages(marsList: List<MarsImageModel>,context: Context) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            items(marsList.size) { mars ->
                ItemRow(marsList[mars],context)
            }
        }
    }

}

@Composable
private fun ItemRow(marsImageModel: MarsImageModel,context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, marsImageModel.id.toString(), Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(10.dp)
            .background(color = Color.DarkGray, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = marsImageModel.img_src,
            contentDescription = null,
            modifier = Modifier
                .background(shape = RoundedCornerShape(10.dp), color = Color.Gray)
                .width(200.dp)
                .height(200.dp),
            contentScale = ContentScale.Crop,
        )
        Column {
            CustomText(field = "Camera", text = marsImageModel.cameraName?:"_____")
            CustomText(field = "Name", text = marsImageModel.cameraFullName?:"_____")
            CustomText(field = "Sol", text = marsImageModel.sol.toString())
            CustomText(field = "Status", text = marsImageModel.rovStatus?:"_____")
            CustomText(field = "Total Images", text = marsImageModel.totalImages.toString())
        }


    }
}

@Composable
fun CustomText(field: String, text: String) {
    Text(
        text = "$field : $text",
        color = Color.White,
        fontFamily = FontFamily.SansSerif,
        fontSize = 18.sp,
        style = TextStyle.Default
    )
}









