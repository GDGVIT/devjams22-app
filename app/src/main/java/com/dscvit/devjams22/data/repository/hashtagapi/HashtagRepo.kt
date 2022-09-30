package com.dscvit.devjams22.data.repository.hashtagapi

import com.dscvit.devjams22.data.remote.dto.InstaFeed
import javax.inject.Inject

class HashtagRepo @Inject constructor(
    private val hashtagApi: HashtagApi
) {
    suspend fun getImages(): InstaFeed {
        return hashtagApi.getImage()
    }
}