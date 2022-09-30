package com.dscvit.devjams22.data.repository

import com.dscvit.devjams22.common.State
import com.dscvit.devjams22.data.remote.dto.TimelineDC
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await


class TimelineRepository {
    private val mTimelineCollection = FirebaseFirestore.getInstance().collection("timeline")
    fun getAllPosts() = flow<State<List<TimelineDC>>> {

        emit(State.loading())

        val snapshot = mTimelineCollection.get().await()
        val timelines = snapshot.toObjects(TimelineDC::class.java)

        emit(State.success(timelines))


    }.catch {
        emit(State.failed(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}