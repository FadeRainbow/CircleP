package dev.faderainbow.circlep

import androidx.compose.desktop.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application


/**
 *@author FadeRainbow
 *@date 2023/7/6
 *@time 10:48
 */
/**
 * Column垂直布局
 * Row水平布局
 * Box 是一个能够将里面的子项依次按照顺序堆叠的布局组件
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun Client() {
    var account by remember {
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    val openDialog = remember { mutableStateOf(true) }

    MaterialTheme {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Column(
        ){
            TextField(
                value = account,
                onValueChange = {
                    account = it
                },
                singleLine = true,
                label = {
                    Text("账户")
                },
                leadingIcon = {
                    Icon(Icons.Filled.AccountCircle,"账号")
                }
            )
            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                singleLine = true,
                label = {
                    Text("密码")
                },
                leadingIcon = {
                    Icon(Icons.Filled.Lock,"密码")
                }
            )
            Button(
                onClick= {
                    if (account.isEmpty() || password.isEmpty()) {
                        if (openDialog.value) {
                            AlertDialog(
                                onDismissRequest = {
                                    openDialog.value = false
                                },
                                title = {
                                    Text(
                                        text = "警告>_<",
                                        fontWeight = FontWeight.W700,
                                        style = MaterialTheme.typography.h6
                                    )
                                },
                                text = {
                                    Text(
                                        text = "旅行者大人请输入账号密码注入我的身体哦~",
                                        fontSize = 16.sp
                                    )
                                },
                                confirmButton = {
                                    TextButton(
                                        onClick = {
                                            openDialog.value = false
                                        },
                                    ) {
                                        Text(
                                            "我了解辣",
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
                                            "我了解哦",
                                            fontWeight = FontWeight.W700,
                                            style = MaterialTheme.typography.button
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            ){
                Text("原神启动")
            }
        }
    }
    }
}
    fun main() = application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "原神",
            state = WindowState(width = 400.dp, height = 400.dp),
            icon = painterResource("icon/windowIcon.jpg"),


        ) {
           Client()
            AntiOP.Dialog()
        }
    }
