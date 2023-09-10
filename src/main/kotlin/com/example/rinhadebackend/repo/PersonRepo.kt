package com.example.rinhadebackend.repo

import com.example.rinhadebackend.model.Person
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PersonRepo: ReactiveCrudRepository<Person, String> {

    override fun count(): Mono<Long>

    fun findAllByStackContaining(stack: String): Flux<Person>
}