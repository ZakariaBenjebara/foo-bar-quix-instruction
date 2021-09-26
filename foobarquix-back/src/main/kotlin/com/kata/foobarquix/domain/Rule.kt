package com.kata.foobarquix.domain

interface Rule {
    fun apply(number: Int) : RuleResult
}

object NoRule : Rule {
    override fun apply(number: Int) : RuleResult = RuleResult(number.toString())
}

data class RuleResult(val value: String)
