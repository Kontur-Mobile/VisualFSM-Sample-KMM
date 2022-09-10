package ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.actions

import ru.kontur.mobile.visualfsm.Transition
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.AuthFSMState

class HandleSnackBarShowed() : AuthFSMAction() {

    inner class SnackBarShowed : Transition<AuthFSMState.Login, AuthFSMState.Login>() {
        override fun transform(state: AuthFSMState.Login): AuthFSMState.Login {
            return state.copy(snackBarMessage = null)
        }
    }
}