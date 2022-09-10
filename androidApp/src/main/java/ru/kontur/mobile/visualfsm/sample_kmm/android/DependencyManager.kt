package ru.kontur.mobile.visualfsm.sample_kmm

import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.AuthFSMState
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.AuthFeature

class DependencyManager {
    companion object {
        private val authFeature = AuthFeature(
            initialState = AuthFSMState.Login("", "")
        )

        fun getAuthFeature(): AuthFeature {
            return authFeature
        }
    }
}