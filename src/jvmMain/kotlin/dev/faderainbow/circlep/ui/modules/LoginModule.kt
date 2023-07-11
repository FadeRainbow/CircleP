package dev.faderainbow.circlep.ui.modules

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
import dev.faderainbow.circlep.ui.helper.LoginHelper

import dev.faderainbow.circlep.utils.RandomUtils
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import kotlin.system.exitProcess

/**
 *@author FadeRainbow
 *@date 2023/7/9
 *@time 10:27
 */

object LoginModule {

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    @Preview
    fun LoginUI() {
        var account by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        var accountName by remember {
            mutableStateOf("")
        }
        var idNumber by remember {
            mutableStateOf("")
        }

        var input by remember {
            mutableStateOf("")
        }
        var verificationCode by remember {
            mutableStateOf(RandomUtils.randomString(RandomUtils.randomLength(3, 6)))
        }
        var showDialog by remember { mutableStateOf(false) }
        var authenticationDialog by remember { mutableStateOf(false) }
        var neverEnabled by remember { mutableStateOf(false) }
        var verificationSuccessful by remember { mutableStateOf(false) }
        var showSwitchWindow by remember { mutableStateOf(true) }
        MaterialTheme {
            LoginHelper.AntiOP()
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            )
            {
                Column(
                ) {
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
                            Icon(Icons.Filled.AccountCircle, "账号")
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
                            Icon(Icons.Filled.Lock, "密码")
                        }
                    )
                    Button(
                        onClick = {
                            if (account.isEmpty() || password.isEmpty()) {
                                showDialog = true
                            }
                            if (account.isNotEmpty() && password.isNotEmpty()) {
                                authenticationDialog = true
                            }
                            if (neverEnabled) {
                                authenticationDialog = false
                            }
                            if (input != verificationCode) {
                                verificationSuccessful = false
                                verificationCode = RandomUtils.randomString(RandomUtils.randomLength(3, 6))
                            }
                            //ClickedShow->
                                if(account.isNotEmpty() && password.isNotEmpty()&&input == verificationCode) {
                                    showSwitchWindow = true
                                }

                        }
                    ) {
                        Text("原神启动")
                    }
                    //验证码 verificationCode
                    Row(
                    ) {

                        TextField(
                            value = input,
                            onValueChange = {
                                input = it
                            },
                            singleLine = false,
                            label = {
                                Text("验证码")
                            }
                        )
                        Text(
                            text = verificationCode
                        )
                    }
                }
            }
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = "警告>_<",
                        fontWeight = FontWeight.W700,
                        style = MaterialTheme.typography.h6
                    )
                },
                text = {
                    Text(
                        text = "旅行者请输入账户密码到我身体里哦~",
                        fontSize = 16.sp
                    )
                },
                confirmButton = {
                    Button(
                        onClick = { showDialog = false }
                    ) {
                        Text(
                            "好的捏",
                            fontWeight = FontWeight.W700,
                            style = MaterialTheme.typography.button
                        )

                    }
                }, modifier = Modifier.aspectRatio(1.5f)
            )
        }

        if (authenticationDialog) {
            Column {
                AlertDialog(
                    onDismissRequest = { authenticationDialog = false },
                    title = {
                        Text(
                            "实名认证"
                        )
                    },
                    text = {
                        Column {
                            TextField(
                                value = accountName,
                                onValueChange = {
                                    accountName = it
                                },
                                singleLine = true,
                                label = {
                                    Text("姓名")
                                }, modifier = Modifier.padding(bottom = 8.dp)
                            )
                            TextField(
                                value = idNumber,
                                onValueChange = {
                                    idNumber = it
                                },
                                singleLine = true,
                                label = {
                                    Text("身份证号码")
                                }
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                authenticationDialog = false
                                neverEnabled = true
                            }
                        ) {
                            Text(
                                "确认"
                            )
                        }
                    }
                )
            }
        }
        if(showSwitchWindow){
            Window(
                onCloseRequest = {
                      showSwitchWindow==false
                },
                title = "请选择你的英雄",
                state = WindowState(width = 400.dp, height = 400.dp),
                icon = painterResource("icon/windowIcon.jpg"),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom,
                    ){
                        Button(
                            onClick = {
                                showSwitchWindow=false
                            }
                        ){
                            Text("返回")
                        }
                    }
                }
            }
        }
    }
}