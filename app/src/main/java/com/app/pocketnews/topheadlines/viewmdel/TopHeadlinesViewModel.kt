package com.app.pocketnews.topheadlines.viewmdel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pocketnews.topheadlines.data.TopHeadlinesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopHeadlinesViewModel(private val topHeadlinesUseCase: TopHeadlinesUseCase) : ViewModel() {


    fun getTopHeadlines() {
        viewModelScope.launch(Dispatchers.IO) {
            val topHeadlinesNewsResponse = topHeadlinesUseCase.getTopHeadlines()
            Log.d("###", "topheadlines response status ${topHeadlinesNewsResponse.status}")
        }
    }

}