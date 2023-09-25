package com.ashutoshwahane.modernandroid.glance

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.google.gson.Gson
import dev.ashutoshwahane.data.BuildConfig
import dev.ashutoshwahane.data.datasource.api.RetrofitInstance
import dev.ashutoshwahane.data.datasource.api.services.ImageApi
import entity.MarsEntity

object ApodWidget: GlanceAppWidget() {

    val jsonStr = stringPreferencesKey("jsonData")


    @Composable
    fun Content(firstData: String) {
        val jsonData = currentState(key = jsonStr) ?: ""

        if (jsonData.isNullOrEmpty()){
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .background(Color.DarkGray),
                verticalAlignment = Alignment.Vertical.CenterVertically,
                horizontalAlignment = Alignment.Horizontal.CenterHorizontally
            ) {
                Text(
                    text = firstData,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        color = ColorProvider(Color.White),
                        fontSize = 26.sp
                    )
                )
                Button(
                    text = "Refresh data",
                    onClick = actionRunCallback(RefreshActionCallback::class.java)
                )
            }
        } else {
            val marsEntity = Gson().fromJson(jsonData, MarsEntity::class.java)
            LazyColumn (
                modifier = GlanceModifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .background(Color.DarkGray),
            ) {
                items(15) { index: Int ->
                    Text(
                        text = "Mars Rover ID: ${marsEntity.photos[index].rover.id} ${marsEntity.photos[index].sol}",
                        modifier = GlanceModifier.fillMaxWidth(),
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            color = ColorProvider(Color.White),
                            fontSize = 18.sp
                        )

                    )
                }
            }
        }

    }

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        val response = getApiData()
        provideContent {
            Content(response.title)
        }
    }

    private suspend fun getApiData(): dev.ashutoshwahane.data.datasource.api.entity.ImageEntity {
        return RetrofitInstance.getRetrofitInstance().create(ImageApi::class.java).getApodImage(BuildConfig.API_KEY)
    }

}





