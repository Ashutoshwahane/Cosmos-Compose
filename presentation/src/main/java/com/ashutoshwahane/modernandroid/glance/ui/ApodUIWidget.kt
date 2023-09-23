package com.ashutoshwahane.modernandroid.glance.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalContext
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.ashutoshwahane.modernandroid.glance.callback.WidgetCallback
import com.ashutoshwahane.modernandroid.views.home.MainActivity


@Composable
fun ApodUiWidget(apoduiState: APODUIState) {

    Column(
        modifier = GlanceModifier
            .width(170.dp).height(130.dp)
            .background(ImageProvider(com.ashutoshwahane.modernandroid.R.drawable.background_widget))
            .clickable(actionStartActivity(activity = MainActivity::class.java))
            .padding(8.dp)
    ) {

        apodHeader()
        apodMainBody(apoduiState)

    }
}

@Composable
fun apodHeader(){

    Row(
        modifier = GlanceModifier.fillMaxWidth()
    ) {
        Image(
            provider = ImageProvider(com.ashutoshwahane.modernandroid.R.drawable.cosmos_icon),
            contentDescription = /*LocalContext.current.getString(com.ashutoshwahane.modernandroid.R.string.desc)*/ ""
        )
    }
}

@Composable
fun apodMainBody(apoduiState: APODUIState){

    Text(
        text = /*LocalContext.current.getString(com.ashutoshwahane.modernandroid.R.string.apod)*/"APOD : ",
        modifier = GlanceModifier.fillMaxWidth().padding(top = 8.dp),
        style = TextStyle(fontWeight = FontWeight.Bold),
    )
    Text(
        text = apoduiState.apodName,
        modifier = GlanceModifier.fillMaxWidth().padding(top = 8.dp),
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
    )

}