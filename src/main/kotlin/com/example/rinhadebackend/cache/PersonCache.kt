package com.example.rinhadebackend.cache

import com.example.rinhadebackend.model.Person
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.Optional

/**
 * @author Jefferson Alves Reis (jefaokpta) < jefaokpta@hotmail.com >
 * Date: 08/09/23
 */
@Service
class PersonCache {

    @CachePut("persons", key = "#person.nome")
    fun cachePerson(person: Person): Person = person

    @Cacheable("persons", key = "#nome")
    fun findByName(nome: String) = Optional.empty<Person>()

    @CacheEvict("persons", key = "#nome")
    fun deleteByName(nome: String) = println("Deleting person $nome")

    @CacheEvict("persons", allEntries = true)
    fun deleteAll() = println("Deleting all persons")
}