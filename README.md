# 💇‍♂️ Telegram Hairdresser Appointment Bot (Kotlin + Spring Boot)

This is a **showcase project** built with **Kotlin**, **Spring Boot**, and the official **Telegram Bots Java SDK** (`telegrambots-springboot-longpolling-starter`).\
The bot allows users to **book hair appointments via Telegram** in a conversational, wizard-style flow.

It’s designed as a starting point for experimenting with chat-based appointment workflows and can be extended to integrate with real-time calendars, backends, or payment systems.

---

## 🚀 Features

- ✅ Built using **Kotlin** and **Gradle**
- ✅ Long-polling Telegram bot integration (no need for exposed webhooks)
- ✅ Conversation flow to:
  - Start a chat
  - Choose a date
  - Pick a time slot
  - Confirm the appointment
- ✅ In-memory session state per user
- ✅ Environment-driven config
- 🔪 Easily extensible with inline keyboards, persistent storage, or APIs

---

## 📦 Requirements

- Java 17+
- Telegram bot token & username from [@BotFather](https://t.me/BotFather)
- Telegram app on your device (iOS or Android)
- Docker (optional, for deployment)

---

## ⚙️ Configuration

Set up the following environment variables in your system or `.env` file:

```env
TELEGRAM_BOT_TOKEN=123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11
TELEGRAM_BOT_USERNAME=your_bot_username_here
```

You can also configure via `application.yml`:

```yaml
telegram:
  bot:
    token: ${TELEGRAM_BOT_TOKEN}
    username: ${TELEGRAM_BOT_USERNAME}

server:
  port: 8080
```

---

## 🧠 How It Works

When users send `/start`, they are welcomed and instructed to type `/book`.\
The bot then guides them through:

1. 📅 Entering a **date**
2. ⏰ Selecting a **time**
3. ✅ Confirming the appointment

The session state is managed in memory (per chat ID).

---

## 🐳 Running with Docker

```bash
./gradlew clean build
docker build -t telegram-appointment-bot .
docker run -e TELEGRAM_BOT_TOKEN=your_token \
           -e TELEGRAM_BOT_USERNAME=your_username \
           telegram-appointment-bot
```

---

## 📱 Using the Bot

1. Go to [Telegram](https://t.me) and search for your bot username
2. Click **Start**
3. Type `/book`
4. Follow the prompts!

---

## 🧹 Next Steps (Tracked in GitHub Issues)

- Add inline keyboard for time slot selection
- Persist booking sessions to a database or Google Sheets
- Admin panel to list/view appointments
- Cancellation or rescheduling support
- User contact information collection
- Multilingual support

---

## 🧑‍💻 Author

Created by [Andrés Pedraza Míguez](https://github.com/your-username) as a personal exploration of Telegram bots using Kotlin and Spring Boot.

---

## 📝 License

MIT – Feel free to copy, learn, and extend.

