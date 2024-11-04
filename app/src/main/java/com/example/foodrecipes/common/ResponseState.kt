package com.example.foodrecipes.common

sealed class ResponseState<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ResponseState<T>(data = data)
    class Error<T>(errorMessage: String) : ResponseState<T>(message = errorMessage)
    class Loading<T> : ResponseState<T>()
    class Empty<T> : ResponseState<T>()
}