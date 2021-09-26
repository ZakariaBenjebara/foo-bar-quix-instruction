package com.kata.foobarquix

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext

object TestBeanInitializer : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(applicationContext: GenericApplicationContext) {
        beans().initialize(applicationContext)
    }
}
