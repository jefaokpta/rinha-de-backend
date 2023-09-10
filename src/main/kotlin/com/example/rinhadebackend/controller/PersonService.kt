package com.example.rinhadebackend.controller

import com.example.rinhadebackend.model.Person
import com.example.rinhadebackend.model.PersonDTO
import com.example.rinhadebackend.repo.PersonRepo
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepo: PersonRepo) {

    fun listAll() = personRepo.findAll()
        .map(::PersonDTO)

    fun count() = personRepo.count()

    fun create(personDTO: PersonDTO) = personRepo.save(Person(personDTO))
        .map (::PersonDTO)

    fun findById(id: String) = personRepo.findById(id)
        .map(::PersonDTO)

    fun findByTerm(term: String) = personRepo.findAllByStackContaining(term)
        .map(::PersonDTO)
}