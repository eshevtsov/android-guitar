package com.eshevtsov.android.guitar.assistant.core.feature

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.eshevtsov.android.guitar.assistant.core.feature.data.ErrorTestData
import com.eshevtsov.android.guitar.assistant.core.feature.data.ONE
import com.eshevtsov.android.guitar.assistant.core.feature.error.ErrorSource
import com.eshevtsov.android.guitar.assistant.core.feature.error.exceptionHandler
import com.eshevtsov.android.guitar.assistant.core.feature.lifecycle.SingleLiveEvent
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class ErrorSourceTest {
    @get:Rule
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Test
    fun post_error_message_to_source_and_then_observer_get_it() {
        val errorSource = object : ErrorSource {
            override val errorEvent = SingleLiveEvent<String>()
        }
        val message = ErrorTestData.firstErrorMessage
        val observer = spyk(Observer<String> {})

        errorSource.errorEvent.run {
            observeForever(observer)
            postValue(message)
        }

        verify(exactly = ONE) { observer.onChanged(message) }
    }

    @Test
    fun coroutine_throw_exception_error_event_gets_message() = runBlockingTest {
        val errorMessage = ErrorTestData.firstErrorMessage
        val errorEventLiveData = spyk(SingleLiveEvent<String>())
        val errorSource = object : ErrorSource {
            override val errorEvent = errorEventLiveData
            fun throwException() {
                launch(exceptionHandler) {
                    throw Exception(errorMessage)
                }
            }
        }

        errorSource.throwException()

        verify(exactly = ONE) { errorEventLiveData.postValue(errorMessage) }
    }
}