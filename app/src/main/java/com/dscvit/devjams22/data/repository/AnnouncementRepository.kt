package com.dscvit.devjams22.data.repository

import com.dscvit.devjams22.common.State
import com.dscvit.devjams22.data.remote.dto.AnnouncementDC
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await


class AnnouncementRepository {
    private val mAnnouncementCollection = FirebaseFirestore.getInstance().collection("announce")
    fun getAllPosts() = flow<State<List<AnnouncementDC>>> {

        emit(State.loading())

        val snapshot = mAnnouncementCollection.get().await()
        val announcement = snapshot.toObjects(AnnouncementDC::class.java)

        emit(State.success(announcement))


    }.catch {
        emit(State.failed(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}