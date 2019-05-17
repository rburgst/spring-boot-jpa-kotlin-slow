package com.example.jpademo

import com.example.jpademo.entities.Person
import com.example.jpademo.repositories.PersonRepository
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.hasItem
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import javax.transaction.Transactional
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class JpaDemoApplicationTests {

    @Autowired
    lateinit var personRepository: PersonRepository

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Transactional
    fun contextLoads() {
        val person = Person().apply {
            firstname = "Dave"
            lastname = "Syer"
        }

        personRepository.save(person)

        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(jsonPath("$[*].firstname", hasItem("Dave")))
    }

}
