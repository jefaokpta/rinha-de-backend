package com.example.rinhadebackend.controller

import com.example.rinhadebackend.cache.PersonCache
import com.example.rinhadebackend.model.Person
import com.example.rinhadebackend.model.PersonDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/pessoas")
class PersonController(
    private val personService: PersonService,
    private val personCache: PersonCache
) {

    @GetMapping
    fun listAll() = personService.listAll()

    @PostMapping
    fun create(@RequestBody personDTO: PersonDTO) = personCache.cachePerson(Person(personDTO))

    @GetMapping("/cache/{nome}")
    fun findByName(@PathVariable nome: String) = personCache.findByName(nome)
        .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada")}

    @DeleteMapping("/cache/{nome}")
    fun deleteByName(@PathVariable nome: String) = personCache.deleteByName(nome)
}