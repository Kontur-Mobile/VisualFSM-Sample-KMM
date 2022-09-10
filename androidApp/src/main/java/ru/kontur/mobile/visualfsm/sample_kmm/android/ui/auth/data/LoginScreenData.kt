package ru.kontur.mobile.visualfsm.sample_kmm.android.ui.auth.data

import ru.kontur.mobile.visualfsm.sample_kmm.android.ui.auth.data.AuthScreenData

data class LoginScreenData(
    val mail: String,
    val password: String,
    val errorMessage: String?,
    val isAuthenticationInProgress: Boolean,
    val snackBarMessage: String?
) : AuthScreenData()