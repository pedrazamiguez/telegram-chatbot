package es.pedrazamiguez.telegramchatbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TelegramChatbotApplication

fun main(args: Array<String>) {
	runApplication<TelegramChatbotApplication>(*args)
}
