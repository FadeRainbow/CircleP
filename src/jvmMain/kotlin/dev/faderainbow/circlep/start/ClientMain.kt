package dev.faderainbow.circlep.start

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import dev.faderainbow.circlep.ui.helper.LoginHelper
import dev.faderainbow.circlep.ui.modules.LoginModule



fun main() = application {
        Window(
            onCloseRequest = {
                ::exitApplication
            },
            title = "原神:星穹铁道",
            state = WindowState(width = 400.dp, height = 400.dp),
            icon = painterResource("icon/windowIcon.jpg"),
        ) {
            LoginModule.LoginUI()
        }

    }

