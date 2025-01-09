package com.octoeddy.circuitpresenter.circuit

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui


@Parcelize
object DemoScreenKey : Screen

data class DemoUiState(
    val message: String
) : CircuitUiState


@Composable
fun DemoScreen(
    state: DemoUiState,
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxSize()) {
        Column(Modifier.align(Alignment.Center)) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = state.message,
                style = typography.displayLarge,
                color = colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

class DemoUiFactory : Ui.Factory {
    override fun create(screen: Screen, context: CircuitContext): Ui<*>? {
        return when (screen) {
            is DemoScreenKey -> ui<DemoUiState> { state, modifier ->
                DemoScreen(
                    state,
                    modifier
                )
            }
            else -> null
        }
    }
}




