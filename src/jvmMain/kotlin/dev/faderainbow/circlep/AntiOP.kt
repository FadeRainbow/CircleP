package dev.faderainbow.circlep

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp



/**
 *@author FadeRainbow
 *@date 2023/7/6
 *@time 17:56
 */

@OptIn(ExperimentalMaterialApi::class)
    object AntiOP {
    @Composable
    fun Dialog() {
        val openDialog = remember { mutableStateOf(true) }
        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(
                        text = "原神最好玩",
                        fontWeight = FontWeight.W900,
                        style = MaterialTheme.typography.h6
                    )
                },
                text = {
                    Text(
                        text = "我是原神的狗，我是OP",
                        fontSize = 20.sp//16
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        },
                    ) {
                        Text(
                            "我也是OP",
                            fontWeight = FontWeight.W700,
                            style = MaterialTheme.typography.button
                        )
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false

                        }
                    ) {
                        Text(
                            "我不是OP",
                            fontWeight = FontWeight.W700,
                            style = MaterialTheme.typography.button
                        )
                    }
                },modifier = Modifier.aspectRatio(2f)
            )
        }
    }
}