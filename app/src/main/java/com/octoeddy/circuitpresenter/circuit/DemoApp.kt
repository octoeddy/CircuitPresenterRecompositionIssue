package com.octoeddy.circuitpresenter.circuit


import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.CircuitContent
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.presenter.presenterOf
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui

@Composable
fun DemoApp(
    circuit: Circuit = buildCircuit(),
    colorScheme: ColorScheme = MaterialTheme.colorScheme,
) {
    MaterialTheme(colorScheme = colorScheme) {
        CircuitCompositionLocals(circuit) { CircuitContent(DemoScreenKey) }
    }
}

fun buildCircuit(
    presenterFactory: Presenter.Factory = DemoPresenterFactory(),
    uiFactory: Ui.Factory = DemoUiFactory(),
): Circuit {
    return Circuit.Builder().addPresenterFactory(presenterFactory).addUiFactory(uiFactory).build()
}

