package com.dp.compose_neostore.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dp.core.ResultWrapper
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel : ViewModel() {

    private val bgJobs = ArrayList<Job>()

    internal fun <T> executeUseCaseResult(
        task: suspend () -> ResultWrapper<Throwable, T>,
        onSuccess: (T) -> Unit,
        onError: (String) -> Unit,
    ) {
        val dfJob = viewModelScope.launch {
            val result = withContext(this.coroutineContext) {
                return@withContext withContext(this.coroutineContext) {
                    task.invoke()
                }
            }
            when (result) {
                is ResultWrapper.Success -> onSuccess.invoke(result.value)
                is ResultWrapper.Error -> onError.invoke(result.error.message ?: "Something wrong!")
            }
        }
        bgJobs.add(dfJob)
    }

    override fun onCleared() {
        super.onCleared()
        bgJobs.forEach { job ->
            if (!job.isCancelled) {
                job.cancel()
            }
        }
    }

}