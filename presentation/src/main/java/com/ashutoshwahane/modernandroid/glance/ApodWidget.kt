package com.ashutoshwahane.modernandroid.glance

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.datastore.preferences.core.Preferences
import androidx.glance.GlanceId
import androidx.glance.LocalContext
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.currentState
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import com.ashutoshwahane.modernandroid.glance.ui.APODUIState
import com.ashutoshwahane.modernandroid.glance.ui.ApodUiWidget
import com.ashutoshwahane.modernandroid.ui.theme.ModernAndroidTheme
import com.ashutoshwahane.modernandroid.util.darkModeEnabled


class ApodWidget : GlanceAppWidget() {


    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Content()
        }
    }

    @Composable
    fun Content() {
        val prefs = currentState<Preferences>()
        val getAPODName = prefs[APODWidgetReceiver.apodName]
        val imageUrl = prefs[APODWidgetReceiver.imageUrl]
        val apoduiState = APODUIState(
            apodName = getAPODName ?: "",
            apodImg = imageUrl ?: ""
        )
        ApodUiWidget(apoduiState)

    }

}
