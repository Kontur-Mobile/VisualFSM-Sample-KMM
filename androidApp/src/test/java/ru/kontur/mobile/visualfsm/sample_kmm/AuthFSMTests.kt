package ru.kontur.mobile.visualfsm.sample_kmm

import org.junit.Assert.assertTrue
import org.junit.Test
import ru.kontur.mobile.visualfsm.tools.VisualFSM
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.*
import ru.kontur.mobile.visualfsm.sample_kmm.feature.auth.fsm.actions.AuthFSMAction

class AuthFSMTests {

    @Test
    fun generateDigraph() {
        println(
            VisualFSM.generateDigraph(
                baseAction = AuthFSMAction::class,
                baseState = AuthFSMState::class,
                initialState = AuthFSMState.Login::class,
            )
        )
        assertTrue(true)
    }

    @Test
    fun allStatesReachableTest() {
        val notReachableStates = VisualFSM.getUnreachableStates(
            baseAction = AuthFSMAction::class,
            baseState = AuthFSMState::class,
            initialState = AuthFSMState.Login::class,
        )

        assertTrue(
            "FSM have unreachable states: ${notReachableStates.joinToString(", ")}",
            notReachableStates.isEmpty()
        )
    }

    @Test
    fun noFinalStateTest() {
        val finalStates = VisualFSM.getFinalStates(
            baseAction = AuthFSMAction::class,
            baseState = AuthFSMState::class,
        )

        assertTrue(
            "FSM have not correct final states: ${finalStates.joinToString(", ")}",
            finalStates.isEmpty()
        )
    }
}