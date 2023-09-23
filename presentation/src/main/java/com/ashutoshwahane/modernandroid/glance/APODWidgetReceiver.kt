package com.ashutoshwahane.modernandroid.glance

import android.content.Context
import android.content.Intent
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ashutoshwahane.modernandroid.glance.callback.WidgetCallback
import dagger.hilt.android.AndroidEntryPoint
import dev.ashutoshwahane.domain.repository.ImageRepository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class APODWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = ApodWidget()

    private val coroutineScope = MainScope()

    @Inject
    lateinit var imageRepository: ImageRepository

    private fun observeData(context: Context) {
        coroutineScope.launch {
            val response = imageRepository.getApodImage()

            val glanceId = GlanceAppWidgetManager(context).getGlanceIds(ApodWidget::class.java).firstOrNull()
            glanceId?.let {
                updateAppWidgetState(context = context, PreferencesGlanceStateDefinition, it) {preferences ->
                    preferences.toMutablePreferences().apply {
                        this[apodName] = response.imageTitle
                        this[imageUrl] = response.lowQualityImage
                    }
                }
                glanceAppWidget.update(context = context, it)
            }
        }
    }



    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == WidgetCallback.UPDATE_ACTION) {
            observeData(context)
        }
    }


    companion object {
        val apodName = stringPreferencesKey("apodName")
        val imageUrl = stringPreferencesKey("imageUrl")
    }
}


class DataSyncWorker(
    val context: Context,
    val params: WorkerParameters,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        // Fetch data or do some work and then update all instance of your widget
        // MyAppWidget().updateAll(context)
        return Result.success()
    }
}
