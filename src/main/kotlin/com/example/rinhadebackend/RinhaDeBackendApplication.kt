package com.example.rinhadebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class RinhaDeBackendApplication

fun main(args: Array<String>) {
    runApplication<RinhaDeBackendApplication>(*args)
}
