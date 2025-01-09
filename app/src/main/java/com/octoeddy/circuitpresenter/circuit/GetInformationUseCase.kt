package com.octoeddy.circuitpresenter.circuit

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object GetInformationUseCase {
    operator fun invoke(): Flow<Result<String>> {
        Log.i("GetInformationUseCase", "invoke()")
        return flowOf(Result.failure(NotImplementedError("Ahh!")))
    }
}
