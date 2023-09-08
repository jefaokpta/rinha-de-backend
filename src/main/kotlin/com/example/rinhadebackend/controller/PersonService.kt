package com.example.rinhadebackend.controller

import com.example.rinhadebackend.model.Person
import com.example.rinhadebackend.model.PersonDTO
import com.example.rinhadebackend.repo.PersonRepo
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepo: PersonRepo) {

    fun listAll() = personRepo.findAll()

    fun create(personDTO: PersonDTO) = personRepo.save(Person(personDTO))
}