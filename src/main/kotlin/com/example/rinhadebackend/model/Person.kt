package com.example.rinhadebackend.model

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("persons")
data class Person(
    @Id
    val personId: String,
    val nome: String,
    val apelido: String,
    val nascimento: String,
    val stack: String?,
): Persistable<String> {

    constructor(personDTO: PersonDTO) : this(
        personDTO.id,
        personDTO.nome,
        personDTO.apelido,
        personDTO.nascimento,
        personDTO.stack?.joinToString(",")
    )

    override fun getId() = personId


    override fun isNew() = true
}