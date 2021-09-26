package com.kata.foobarquix.domain

class Instructions(private val rule: Rule) {

    fun execute(input: Int) : RuleResult {
        return rule.apply(input)
    }
}

