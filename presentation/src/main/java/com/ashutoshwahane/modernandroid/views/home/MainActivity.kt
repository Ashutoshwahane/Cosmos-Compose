package com.ashutoshwahane.modernandroid.views.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.ashutoshwahane.modernandroid.ui.theme.ModernAndroidTheme
import com.ashutoshwahane.modernandroid.views.mars.MarsImagesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Home",Modifier,this)
                }
            }
        }
        viewModel.getApodImage()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,context: Context) {
    Button(onClick = {
        val intent = Intent(context,MarsImagesActivity::class.java)
        context.startActivity(intent)
    }) {
        Text(text ="clickme")

    }

}

fun navigateToMarActivity() {

}




