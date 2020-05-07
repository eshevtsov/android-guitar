package com.eshevtsov.android.guitar.assistant.database.data

interface TestData<T : Any> {
    fun first(): T
    fun second(): T
    fun withoutId(): T

    fun copy(item: T, id: Long? = null): T
}