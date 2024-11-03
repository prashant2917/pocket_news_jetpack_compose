package com.app.pocketnews.topheadlines.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.pocketnews.di.PocketNewsContainer
import com.app.pocketnews.topheadlines.viewmdel.TopHeadlinesViewModel
import java.util.Locale


@Composable
fun TopHeadlinesScreen() {
    val productViewModel: TopHeadlinesViewModel =
        viewModel(factory = PocketNewsContainer.provideTopHeadlinesViewModelFactory().Factory)
    productViewModel.getTopHeadlines()
    Text(text = Locale.getDefault().country)


}