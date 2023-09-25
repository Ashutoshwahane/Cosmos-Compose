package com.ashutoshwahane.modernandroid.glance

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import com.google.gson.Gson
import dev.ashutoshwahane.data.BuildConfig
import dev.ashutoshwahane.data.datasource.api.RetrofitInstance
import dev.ashutoshwahane.data.datasource.api.services.ImageApi
import entity.MarsEntity

class RefreshActionCallback: ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->

            val data = getApiData()
            val jsonData = Gson().toJson(data)
            prefs[ApodWidget.jsonStr] = jsonData

        }
        ApodWidget.update(context, glanceId)
    }

    private suspend fun getApiData(): MarsEntity {
        return RetrofitInstance.getRetrofitInstance().create(ImageApi::class.java).getMarsImage(
            BuildConfig.API_KEY)
    }
}