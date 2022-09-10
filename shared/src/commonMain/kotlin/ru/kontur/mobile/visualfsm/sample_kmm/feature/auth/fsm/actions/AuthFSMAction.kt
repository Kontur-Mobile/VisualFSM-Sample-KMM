package ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.actions

import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.AuthFSMState
import ru.kontur.mobile.visualfsm.Action

sealed class AuthFSMAction : Action<AuthFSMState>()
