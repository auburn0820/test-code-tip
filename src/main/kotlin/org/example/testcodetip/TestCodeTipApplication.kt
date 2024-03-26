package org.example.testcodetip

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class TestCodeTipApplication

fun main(args: Array<String>) {
    runApplication<TestCodeTipApplication>(*args)
}
