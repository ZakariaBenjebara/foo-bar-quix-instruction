package com.kata.foobarquix.services

import com.kata.foobarquix.domain.Instructions
import org.springframework.stereotype.Component

@Component
class FooBarQuixService(private val instructions: Instructions) {

    fun convertNumber(inputNumber: Int): String {
        return instructions.execute(inputNumber).value
    }
}