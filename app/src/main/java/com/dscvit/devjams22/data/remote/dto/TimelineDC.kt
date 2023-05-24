package com.dscvit.devjams22.data.remote.dto

import com.google.firebase.Timestamp

data class TimelineDC(
    val eventName: String? = " ",
    val startTime: Timestamp? = null,
    val endTime: Timestamp? = null,
    var id: Int = -1,
    var newDay: Boolean? = null,
    val day: Int? = null
) {

}





