package com.kata.foobarquix

import com.kata.foobarquix.domain.FooBarQuixRuler
import com.kata.foobarquix.domain.Instructions
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

@SpringBootApplication
class FooBarQuixApplication

fun main(args: Array<String>) {
	runApplication<FooBarQuixApplication>(*args) {
        addInitializers(beans())
    }
}

fun beans() = beans {
    bean {
        Instructions(FooBarQuixRuler)
    }
}
