package com.kata.foobarquix

import com.kata.foobarquix.domain.Instructions
import com.kata.foobarquix.domain.NoRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InstructionTests {

    private val instructions = Instructions(NoRule)

    @Test
    fun `1 should return 1`() {
        val result = instructions.execute(1)
        assertThat(result.value).isEqualTo("1")
    }

    @Test
    fun `3 should return FooFoo`() {
        val result = instructions.execute(3)
        assertThat(result.value).isEqualTo("FooFoo")
    }

    @Test
    fun `5 should return BarBar`() {
        val result = instructions.execute(5)
        assertThat(result.value).isEqualTo("BarBar")
    }

    @Test
    fun `7 should return Quix`() {
        val result = instructions.execute(7)
        assertThat(result.value).isEqualTo("Quix")
    }

    @Test
    fun `9 should return Foo`() {
        val result = instructions.execute(9)
        assertThat(result.value).isEqualTo("Foo")
    }

    @Test
    fun `51 should return FooBar`() {
        val result = instructions.execute(51)
        assertThat(result.value).isEqualTo("FooBar")
    }

    @Test
    fun `53 should return BarFoo`() {
        val result = instructions.execute(53)
        assertThat(result.value).isEqualTo("BarFoo")
    }

    @Test
    fun `33 should return FooFooFoo`() {
        val result = instructions.execute(33)
        assertThat(result.value).isEqualTo("FooFooFoo")
    }

    @Test
    fun `27 should return FooQuix`() {
        val result = instructions.execute(27)
        assertThat(result.value).isEqualTo("FooQuix")
    }

    @Test
    fun `15 should return FooBarBar`() {
        val result = instructions.execute(15)
        assertThat(result.value).isEqualTo("FooBarBar")
    }
}