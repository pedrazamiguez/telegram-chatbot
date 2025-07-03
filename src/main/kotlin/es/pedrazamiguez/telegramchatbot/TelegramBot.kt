package es.pedrazamiguez.telegramchatbot

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.meta.generics.TelegramClient

@Component
class TelegramBot(
    @Value("\${telegram.bot.token}") private val botToken: String,
    private val telegramClient: TelegramClient
) : SpringLongPollingBot {

    override fun getBotToken(): String = botToken

    override fun getUpdatesConsumer(): LongPollingUpdateConsumer {
        return LongPollingUpdateConsumer { updates ->
            updates.forEach { update ->
                onUpdateReceived(update)
            }
        }
    }

    private fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            val messageText = update.message.text
            val chatId = update.message.chatId.toString()

            val responseText = when (messageText.lowercase()) {
                "/start" -> "Hello! Welcome to my bot. Type /help for more info."
                "/help" -> "Available commands:\n/start - Start the bot\n/help - Show this help message"
                else -> "You said: $messageText"
            }

            val sendMessage = SendMessage.builder()
                .chatId(chatId)
                .parseMode("Markdown")
                .text(responseText)
                .build()

            try {
                telegramClient.execute(sendMessage)
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    }
}