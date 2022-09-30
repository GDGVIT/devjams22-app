package com.dscvit.devjams22.data.remote.dto

data class InstaFeed(

    val data: MutableList<Data> = ArrayList(),
    val paging: Paging = Paging()
)

data class Data(

    val permalink: String,
    val caption: String,
    val comments_count: Int,
    val like_count: Int,
    val media_type: String,
    val media_url: String,
    val id: String
)

data class Paging(

    val cursors: Cursors = Cursors(),
    val next: String = ""
)

data class Cursors(

    val after: String = ""
)
