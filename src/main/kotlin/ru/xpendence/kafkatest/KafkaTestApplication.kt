package ru.xpendence.kafkatest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class KafkaTestApplication

fun main(args: Array<String>) {
    runApplication<KafkaTestApplication>(*args)
}
