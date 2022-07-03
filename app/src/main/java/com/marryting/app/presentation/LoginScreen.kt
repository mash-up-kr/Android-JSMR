package com.marryting.app.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kakao.sdk.user.UserApiClient
import com.marryting.app.R
import com.marryting.app.presentation.login.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {

    val context = LocalContext.current
    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 146.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = ""
                )

                Spacer(modifier = Modifier.weight(1f))

                Button(modifier = Modifier.padding(bottom = 78.dp), onClick = {
                    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
                        UserApiClient.instance.loginWithKakaoTalk(
                            context = context,
                            callback = { token, error ->
                            }
                        )
                    } else {
                        UserApiClient.instance.loginWithKakaoAccount(
                            context = context,
                            callback = { token, error ->
                            }
                        )
                    }
                }) {
                    Text(text = "카카오톡으로 시작하기")
                }
            }
        }
    }
}
