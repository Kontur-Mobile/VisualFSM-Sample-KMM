## Sample of usage VisualFSM for KMM (Android + iOS) application - Kotlin Coroutines, Jetpack Compose, SwiftUI

[![Telegram](https://img.shields.io/static/v1?label=Telegram&message=Channel&color=0088CC)](https://t.me/visualfsm)
[![Telegram](https://img.shields.io/static/v1?label=Telegram&message=Chat&color=0088CC)](https://t.me/visualfsm_support)

ENG | [RUS](docs/README-RU.md)

[VisualFSM](https://github.com/Kontur-Mobile/VisualFSM) is a Kotlin library that implements an **MVI architecture**
(`Model-View-Intent`)[[1]](#what-is-mvi) and a set of tools for visualization and analysis of
**FSM**'s (`Finite-state machine`)[[2]](#what-is-fsm) diagram of states.

The graph is being built from source code of **FSM**'s implementation. There is no need of custom
written configurations for **FSM**, you can just create new State and Action classes, they would be
automatically added to the graph of States and Transitions.

Source code analysis and the graph built are being performed with reflection and declared as a
separate module that would allow it to be connected to testing environment.

### Authorization and registration process

<img src="docs/graph.png" alt="graph"/>

Feature: [AuthFeature.kt](./shared/src/commonMain/kotlin/ru/kontur/mobile/visualfsm/sample_kmm/feature/auth/fsm/AuthFeature.kt)

States: [AuthFSMState.kt](./shared/src/commonMain/kotlin/ru/kontur/mobile/visualfsm/sample_kmm/feature/auth/fsm/AuthFSMState.kt)

Actions: [actions](./shared/src/commonMain/kotlin/ru/kontur/mobile/visualfsm/sample_kmm/feature/auth/fsm/actions)

AsyncWorker: [AuthFSMAsyncWorker.kt](./shared/src/commonMain/kotlin/ru/kontur/mobile/visualfsm/sample_kmm/feature/auth/fsm/AuthFSMAsyncWorker.kt)

States to Ui data models mapper: [ScreenDataMapper.kt](./androidApp/src/main/java/ru/kontur/mobile/visualfsm/sample_kmm/android/ui/auth/ScreenDataMapper.kt)

Generate digraph and tests
sample: [AuthFSMTests.kt](./androidApp/src/test/java/ru/kontur/mobile/visualfsm/sample_kmm/AuthFSMTests.kt)

For CI visualization use [graphviz](https://graphviz.org/doc/info/command.html), for the local visualization (on your
PC) use [webgraphviz](http://www.webgraphviz.com/).

### Screenshots

<table width="100%">
  <tr>
  <td width="33%">Login</td>
  <td width="33%">Registration</td>
  <td width="33%">ConfirmationRequested</td>
  </tr>
  <tr>
  <td width="33%"><img src="./docs/login.png"/></td>
  <td width="33%"><img src="./docs/reg.png"/></td>
  <td width="33%"><img src="./docs/confirm.png"/></td>
  </tr>
  <tr>
  <td width="33%">AsyncWorkState.Registering</td>
  <td width="33%">Login with snackbar</td>
  <td width="33%">UserAuthorized</td>
  </tr>
  <tr>
  <td width="33%"><img src="./docs/reg_progress.png"/></td>
  <td width="33%"><img src="./docs/snack.png"/></td>
  <td width="33%"><img src="./docs/welcome.png"/></td>
  </tr>
</table>

### What is MVI

`MVI` stands for **Model-View-Intent**. It is an architectural pattern that utilizes _unidirectional
data flow_. The data circulates between `Model` and `View` only in one direction - from `Model`
to `View` and from `View` to `Model`.

[More on hannesdorfmann](http://hannesdorfmann.com/android/model-view-intent/)

### What is FSM

A `finite-state machine` (FSM) is an abstract machine that can be in exactly one of a finite number
of states at any given time. The `FSM` can change from one state to another in response to some
inputs.

[More on wikipedia](https://en.wikipedia.org/wiki/Finite-state_machine)