package com.dscvit.devjams22.presentation.hashtag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscvit.devjams22.data.remote.dto.InstaFeed
import com.dscvit.devjams22.data.repository.hashtagapi.HashtagRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HashtagViewModel @Inject constructor(
    private val hashtagRepo: HashtagRepo
) : ViewModel() {
    private val _state = MutableStateFlow(InstaFeed())
    val state: StateFlow<InstaFeed>
        get() = _state

    init {
        viewModelScope.launch {
            val images = hashtagRepo.getImages()
            _state.value = images
        }
    }
}