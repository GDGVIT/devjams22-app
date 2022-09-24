package com.dscvit.devjams22.common

data class DataOrException<T, E : Exception?>(
    var data: T? = null,
    var e: E? = null
)
