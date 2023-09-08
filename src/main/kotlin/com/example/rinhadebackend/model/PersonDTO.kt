package com.example.rinhadebackend.model


class PersonDTO(
    val id: Int,
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