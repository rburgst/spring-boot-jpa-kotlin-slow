package com.example.jpademo.rest

import com.example.jpademo.entities.Person
import com.example.jpademo.repositories.PersonRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class PersonController(val personRepository: PersonRepository) {

    @GetMapping("/")
    fun getAll(): Collection<Person> {
        return personRepository.findAll()
    }
}
