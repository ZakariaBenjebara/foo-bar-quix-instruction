package com.kata.foobarquix

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class FooBarQuixApplicationTests {

    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    fun `should result equals to 1 when the input is 1`() {
        this.mockMvc?.perform(get("/foo-bar-quix/1"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"1\"}"))
    }

    @Test
    fun `should return result equals FooFoo when the input is 3`() {
        this.mockMvc?.perform(get("/foo-bar-quix/3"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"FooFoo\"}"))
    }

    @Test
    fun `should return result equals BarBar when the input is 5`() {
        this.mockMvc?.perform(get("/foo-bar-quix/5"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"BarBar\"}"))
    }

    @Test
    fun `should return result equals Quix when the input is 7`() {
        this.mockMvc?.perform(get("/foo-bar-quix/7"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"Quix\"}"))
    }

    @Test
    fun `should return result equals Foo when the input is 9`() {
        this.mockMvc?.perform(get("/foo-bar-quix/9"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"Foo\"}"))
    }

    @Test
    fun `should return result equals FooBar when the input is 51`() {
        this.mockMvc?.perform(get("/foo-bar-quix/51"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"FooBar\"}"))
    }

    @Test
    fun `should return result equals BarFoo when the input is 53`() {
        this.mockMvc?.perform(get("/foo-bar-quix/53"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"BarFoo\"}"))
    }

    @Test
    fun `should return result equals FooFooFoo when the input is 33`() {
        this.mockMvc?.perform(get("/foo-bar-quix/33"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"FooFooFoo\"}"))
    }

    @Test
    fun `should return result equals FooQuix when the input is 27`() {
        this.mockMvc?.perform(get("/foo-bar-quix/27"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"FooQuix\"}"))
    }

    @Test
    fun `should return result equals FooBarBar when the input is 15`() {
        this.mockMvc?.perform(get("/foo-bar-quix/15"))
            ?.andDo(print())
            ?.andExpect(status().isOk)
            ?.andExpect(content().json("{\"result\":\"FooBarBar\"}"))
    }
}
