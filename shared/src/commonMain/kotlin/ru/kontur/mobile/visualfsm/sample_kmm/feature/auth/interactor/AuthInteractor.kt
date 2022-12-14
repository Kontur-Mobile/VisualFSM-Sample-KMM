package ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.interactor

import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.data.AuthResult
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.data.RegistrationResult
import kotlinx.coroutines.delay

class AuthInteractor {
    var registeredMail: String = ""
    var registeredPassword: String = ""

    suspend fun check(mail: String, password: String): AuthResult {
        delay(1500)
        return if (registeredMail == mail && registeredPassword == password
            && mail.isNotBlank() && password.isNotBlank()
        ) {
            AuthResult.SUCCESS
        } else {
            AuthResult.BAD_CREDENTIAL
        }
    }

    suspend fun register(mail: String, password: String): RegistrationResult {
        delay(1500)
        return if (registeredMail == mail) {
            RegistrationResult.USER_ALREADY_REGISTERED
        } else {
            registeredMail = mail
            registeredPassword = password
            RegistrationResult.SUCCESS
        }
    }
}