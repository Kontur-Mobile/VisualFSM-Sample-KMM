package ru.kontur.mobile.visualfsm.sample_kmm

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}