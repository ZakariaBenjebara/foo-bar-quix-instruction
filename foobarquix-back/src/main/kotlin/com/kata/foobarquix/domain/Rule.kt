package com.kata.foobarquix.domain

interface Rule {
    fun apply(number: Int): RuleResult
}

sealed class SpecificationRule(private val specification: Specification, private val result: String) : Rule {
    override fun apply(number: Int): RuleResult = when (specification.isSatisfiedBy(number)) {
        true -> RuleResult(result)
        false -> RuleResult.EMPTY
    }
}

data class NumberDigitsRule(private val rules: Set<Rule>) : Rule {

    override fun apply(number: Int): RuleResult {
        val numbers = number.toString().toCharArray()
        return numbers
            .map { Character.getNumericValue(it) }
            .flatMap { rules.map { rule -> rule.apply(it) } }
            .reduce { a, b -> a + b }
    }
}

object NoRule : Rule {
    override fun apply(number: Int): RuleResult = RuleResult(number.toString())
}

sealed class EqualizerRule(value: Int, result: String) : SpecificationRule(Equalizer(value), result)
sealed class DividerRule(value: Int, result: String) : SpecificationRule(Divider(value), result)

object FooDividerRule : DividerRule(3, "Foo")
object FooEqualizerRule : EqualizerRule(3, "Foo")
object BarDividerRule : DividerRule(5, "Bar")
object BarEqualizerRule : EqualizerRule(5, "Bar")
object QuixEqualizerRule : EqualizerRule(7, "Quix")

data class RuleResult(val value: String) {
    companion object {
        val EMPTY = RuleResult("")
    }

    operator fun plus(that: RuleResult): RuleResult = RuleResult(value + that.value)
}
