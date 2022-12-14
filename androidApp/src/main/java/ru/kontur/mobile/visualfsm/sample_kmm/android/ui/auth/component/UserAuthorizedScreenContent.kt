package ru.kontur.mobile.visualfsm.sample_kmm.android.ui.auth.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kontur.mobile.visualfsm.sample_kmm.android.ui.auth.data.UserAuthorizedScreenData

@Composable
fun UserAuthorizedScreenContent(
    state: UserAuthorizedScreenData,
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(128.dp))
        Text(
            text = "Welcome!",
            fontSize = 26.sp,
        )
        Text(
            text = state.mail,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextButton(
            onClick = onLogoutClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Log out",
                fontSize = 18.sp
            )
        }
    }
}

@Preview
@Composable
fun UserAuthorizedScreenContentPreview() {
    Box(modifier = Modifier.background(MaterialTheme.colors.background)) {
        UserAuthorizedScreenContent(
            UserAuthorizedScreenData(
                mail = "test@test.com"
            )
        ) {}
    }
}