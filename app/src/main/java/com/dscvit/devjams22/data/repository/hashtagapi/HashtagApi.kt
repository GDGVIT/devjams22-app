package com.dscvit.devjams22.data.repository.hashtagapi

import com.dscvit.devjams22.common.Constants
import com.dscvit.devjams22.data.remote.dto.InstaFeed
import retrofit2.http.GET

interface HashtagApi {
    @GET(Constants.ENDPOINT)
    suspend fun getImage(): InstaFeed

}