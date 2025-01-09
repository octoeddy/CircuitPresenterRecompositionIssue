package com.octoeddy.circuitpresenter.circuit

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.presenter.presenterOf
import com.slack.circuit.runtime.screen.Screen

object DemoPresenter : Presenter<DemoUiState> {
    val useCase = GetInformationUseCase

    @Composable
    override fun present(): DemoUiState {
        Log.i("DemoPresenter", "present()")

        val result by useCase().collectAsStateWithLifecycle(null)


        val message = result?.fold(
            onFailure = {
                it.message ?: "Something went wrong!"
            },
            onSuccess = {
                it
            }
        ) ?: "Loading"

        return DemoUiState(
            message = message
        )
    }


}


class DemoPresenterFactory : Presenter.Factory {
    override fun create(
        screen: Screen,
        navigator: Navigator,
        context: CircuitContext,
    ): Presenter<*>? {
        return when (screen) {
            is DemoScreenKey -> DemoPresenter
            else -> null
        }
    }
}