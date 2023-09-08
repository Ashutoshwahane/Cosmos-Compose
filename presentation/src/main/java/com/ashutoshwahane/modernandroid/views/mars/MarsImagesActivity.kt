package com.ashutoshwahane.modernandroid.views.mars

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import com.ashutoshwahane.modernandroid.views.mars.components.MarsImageScreen
import com.ashutoshwahane.modernandroid.views.mars.ui.theme.ModernAndroidTheme
import dagger.hilt.android.AndroidEntryPoint
import dev.ashutoshwahane.domain.model.mars.MarsImageModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MarsImagesActivity : ComponentActivity() {
    private  val  viewModel: MarsImageViewModel by viewModels<MarsImageViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.launch {
            viewModel.getMarsImages()
        }
        val imageList = viewModel.marImageList.value

        setContent {
            ModernAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MarsImageScreen(viewModel,this)
                }
            }
        }
    }
}

