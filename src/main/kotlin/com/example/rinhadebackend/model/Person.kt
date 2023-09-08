package com.example.rinhadebackend.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("persons")
data class Person(
    @Id
    val id: Int,
    val nome: String,
    val apelido: String,
    val nascimento: String,
    val stack: String?,
) {

    constructor(personDTO: PersonDTO) : this(
        personDTO.id,
        personDTO.nome,
        personDTO.apelido,
        personDTO.nascimento,
        personDTO.stack?.joinToString(",")
    )
}