package com.dscvit.devjams22.presentation.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscvit.devjams22.common.State
import com.dscvit.devjams22.data.remote.dto.TimelineDC
import com.dscvit.devjams22.data.repository.TimelineRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class EventsViewModel() : ViewModel() {
    private val repository = TimelineRepository()
    val postState: StateFlow<State<List<TimelineDC>>> =
        getAllPosts().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), State.loading())

    fun getAllPosts() = repository.getAllPosts()

}