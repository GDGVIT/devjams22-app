package com.dscvit.devjams22.presentation.announcements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscvit.devjams22.common.State
import com.dscvit.devjams22.data.remote.dto.AnnouncementDC
import com.dscvit.devjams22.data.repository.AnnouncementRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class AnnouncementViewModel() : ViewModel() {
    private val repository = AnnouncementRepository()
    val postState: StateFlow<State<List<AnnouncementDC>>> =
        getAllPosts().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), State.loading())

    fun getAllPosts() = repository.getAllPosts()

}