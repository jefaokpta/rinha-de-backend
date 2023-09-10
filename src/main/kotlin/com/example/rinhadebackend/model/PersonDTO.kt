package com.example.rinhadebackend.model


class PersonDTO(
    val id: String = java.util.UUID.randomUUID().toString(),
    val nome: String,
    val apelido: String,
    val nascimento: String,
    val stack: List<String>?,
) {
    constructor(person: Person) : this(
        person.id,
        person.nome,
        person.apelido,
        person.nascimento,
        person.stack?.split(",")
    )
}