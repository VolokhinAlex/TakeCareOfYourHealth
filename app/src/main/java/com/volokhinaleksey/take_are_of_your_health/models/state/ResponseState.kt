package com.volokhinaleksey.take_are_of_your_health.models.state

sealed class ResponseState<out T> {
    data class Success<T>(val data: T) : ResponseState<T>()
    data class Error(val error: Throwable) : ResponseState<Nothing>()
    object Loading : ResponseState<Nothing>()
}