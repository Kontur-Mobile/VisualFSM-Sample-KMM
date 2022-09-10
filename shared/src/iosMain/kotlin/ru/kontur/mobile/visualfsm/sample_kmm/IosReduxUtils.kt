package ru.kontur.mobile.visualfsm.sample_kmm

import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.AuthFeature

fun AuthFeature.watchState() = observeState().wrap()
