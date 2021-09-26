package com.kata.foobarquix.domain

object FooBarQuixRuler : Rule {

    private val rules = linkedSetOf(
        FooDividerRule, BarDividerRule, CompositeRule(linkedSetOf(FooEqualizerRule, BarEqualizerRule, QuixEqualizerRule))
    )

    override fun apply(number: Int): RuleResult {
        val result = rules.map { rule -> rule.apply(number) }
            .filter { it != RuleResult.EMPTY }
        if (result.isEmpty()) {
            return NoRule.apply(number)
        }
        return result.reduce { a, b -> a + b }
    }
}