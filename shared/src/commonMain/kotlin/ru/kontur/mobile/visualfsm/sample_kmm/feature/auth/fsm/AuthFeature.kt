package ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm

import ru.kontur.mobile.visualfsm.Feature
import ru.kontur.mobile.visualfsm.GenerateTransitionsFactory
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.data.UserFlow
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.actions.*
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.interactor.AuthInteractor

@GenerateTransitionsFactory
class AuthFeature(initialState: AuthFSMState) : Feature<AuthFSMState, AuthFSMAction>(
    initialState = initialState,
    asyncWorker = AuthFSMAsyncWorker(AuthInteractor()), // In real case inject dependency by DI
    transitionsFactory = GeneratedAuthFeatureTransitionsFactory()
) {

    fun toRegistration() {
        proceed(ChangeFlow(UserFlow.REGISTRATION))
    }

    fun toLogin() {
        proceed(ChangeFlow(UserFlow.LOGIN))
    }

    fun logout() {
        proceed(Logout())
    }

    fun confirmRegistrationData() {
        proceed(HandleConfirmation(true))
    }

    fun declineRegistrationData() {
        proceed(HandleConfirmation(false))
    }

    fun startAuthenticating() {
        proceed(Authenticate())
    }

    fun startRegistration() {
        proceed(StartRegistration())
    }

    fun handleChangeRegistrationData(mail: String, password: String, repeatPassword: String) {
        proceed(HandleChangeRegistrationData(mail, password, repeatPassword))
    }

    fun handleChangeLoginData(mail: String, password: String) {
        proceed(HandleChangeLoginData(mail, password))
    }

    fun handleSnackBarShowed() {
        proceed(HandleSnackBarShowed())
    }
}