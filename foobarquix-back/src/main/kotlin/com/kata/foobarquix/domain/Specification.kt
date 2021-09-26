package com.kata.foobarquix.domain

sealed class Specification {
    abstract fun isSatisfiedBy(number: Int): Boolean
}

data class Divider(private val value: Int) : Specification() {
    override fun isSatisfiedBy(number: Int) : Boolean = number % value == 0
}

data class Equalizer(private val value: Int) : Specification() {
    override fun isSatisfiedBy(number: Int) : Boolean = number == value
}