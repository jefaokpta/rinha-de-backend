package com.example.rinhadebackend.controller

import com.example.rinhadebackend.model.PersonDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pessoas")
class PersonController(private val personService: PersonService) {

    @GetMapping
    fun listAll() = personService.listAll()

    @PostMapping
    fun create(@RequestBody personDTO: PersonDTO) = personService.create(personDTO)
}