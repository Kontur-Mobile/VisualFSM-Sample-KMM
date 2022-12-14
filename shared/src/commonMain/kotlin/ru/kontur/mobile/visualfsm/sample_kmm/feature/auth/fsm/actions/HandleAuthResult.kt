package ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.actions

import ru.kontur.mobile.visualfsm.Transition
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.AuthFSMState.*
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.data.AuthResult

class HandleAuthResult(val result: AuthResult) : AuthFSMAction() {

    inner class Success : Transition<AsyncWorkState.Authenticating, UserAuthorized>() {
        override fun predicate(state: AsyncWorkState.Authenticating): Boolean {
            return result == AuthResult.SUCCESS
        }

        override fun transform(state: AsyncWorkState.Authenticating): UserAuthorized {
            return UserAuthorized(state.mail)
        }
    }

    inner class BadCredential : Transition<AsyncWorkState.Authenticating, Login>() {
        override fun predicate(state: AsyncWorkState.Authenticating): Boolean {
            return result == AuthResult.BAD_CREDENTIAL
        }

        override fun transform(state: AsyncWorkState.Authenticating): Login {
            return Login(state.mail, state.password, "Bad credential")
        }
    }

    inner class ConnectionFailed : Transition<AsyncWorkState.Authenticating, Login>() {
        override fun predicate(state: AsyncWorkState.Authenticating): Boolean {
            return result == AuthResult.NO_INTERNET
        }

        override fun transform(state: AsyncWorkState.Authenticating): Login {
            return Login(state.mail, state.password, "No internet")
        }
    }
}