package com.example.rinhadebackend.controller

import com.example.rinhadebackend.cache.PersonCache
import com.example.rinhadebackend.model.PersonDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/pessoas")
class PersonController(
    private val personService: PersonService,
    private val personCache: PersonCache
) {

    @GetMapping("/contagem-pessoas")
    fun numberOfPersons() = personService.count()


    @PostMapping
    fun create(@RequestBody personDTO: PersonDTO) = ResponseEntity
        .status(HttpStatus.CREATED)
        .header("Location", "/pessoas/${personDTO.id}")
        .body(personService.create(personDTO))

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = personService.findById(id)
        .switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada")))

    @GetMapping
    fun findByTerm(@RequestParam t: String) = personService.findByTerm(t)

    @GetMapping("/cache/{nome}")
    fun findByName(@PathVariable nome: String) = personCache.findByName(nome)
        .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada")}

    @DeleteMapping("/cache/{nome}")
    fun deleteByName(@PathVariable nome: String) = personCache.deleteByName(nome)
}