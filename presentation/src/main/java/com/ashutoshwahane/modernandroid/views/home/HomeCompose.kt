package com.ashutoshwahane.modernandroid.views.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import kotlin.math.absoluteValue

@ExperimentalFoundationApi
class HomeCompose {


    @Composable
    fun HomeScreen() {

        val viewModel: HomeViewModel = viewModel()

        val pagerState = rememberPagerState(pageCount = {
            viewModel.marImageList.value.size
        })
        HorizontalPager(state = pagerState) { page ->
            Card(
                Modifier
                    .size(250.dp)
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        // We animate the alpha, between 50% and 100%
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                viewModel.marImageList.value.forEach {
                    Log.d("mars", "item : ${it.img_src}")
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize(),
                        model = it.img_src,
                        contentDescription = it.cameraFullName
                    )

                    Text(
                        text = it.id.toString(),
                        style = MaterialTheme.typography.headlineSmall,
                    )
                }
            }
        }
    }

}