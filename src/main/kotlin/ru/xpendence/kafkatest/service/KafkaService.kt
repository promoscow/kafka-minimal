package ru.xpendence.kafkatest.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service


@Service
class KafkaService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    fun send() {
        val message = "test message ${System.currentTimeMillis()}"
        println("<-- $message")
        kafkaTemplate.send("kafkaTest", message)
    }

    @KafkaListener(id = "kafkaTest", topics = ["kafkaTest"])
    fun listenGroupFoo(message: String) {
        println("--> $message")
    }
}