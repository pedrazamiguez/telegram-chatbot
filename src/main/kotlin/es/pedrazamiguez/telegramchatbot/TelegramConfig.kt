package es.pedrazamiguez.telegramchatbot

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.generics.TelegramClient
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient

@Configuration
class TelegramConfig {

    @Bean
    fun telegramClient(@Value("\${telegram.bot.token}") botToken: String): TelegramClient {
        return OkHttpTelegramClient(botToken)
    }
}