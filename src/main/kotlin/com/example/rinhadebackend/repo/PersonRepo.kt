package com.example.rinhadebackend.repo

import com.example.rinhadebackend.model.Person
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PersonRepo: ReactiveCrudRepository<Person, Int> {
}