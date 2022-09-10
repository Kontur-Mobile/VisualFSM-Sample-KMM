package ru.kontur.mobile.visualfsm.sample_kmm.android.ui.auth.data

import ru.kontur.mobile.visualfsm.sample_kmm.android.ui.auth.data.AuthScreenData

data class RegistrationScreenData(
    val mail: String,
    val password: String,
    val repeatedPassword: String,
    val errorMessage: String?,
    val isRegistrationInProgress: Boolean,
    val isConfirmationRequested: Boolean,
) : AuthScreenData()