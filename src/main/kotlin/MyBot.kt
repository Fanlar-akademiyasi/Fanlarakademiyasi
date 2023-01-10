import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.ParseMode
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class MyBot : TelegramLongPollingBot() {
    override fun getBotToken(): String {
        return "5798309523:AAGxJcHaJ9eS-rGfeUMUcIvAN4oczNY187g"
    }

    override fun getBotUsername(): String {
        return "faqaytaaloqabot"
    }

    private fun sendWithoutUrl(message: Message) {
        val keyboard = InlineKeyboardMarkup()
        val buttonUz = InlineKeyboardButton()
        val buttonRu = InlineKeyboardButton()

        buttonUz.text = "O'zbek tili"
        buttonRu.text = "Russkiy"
        buttonUz.callbackData = "uz"
        buttonRu.callbackData = "ru"

        val keyboardButtonsRow = ArrayList<InlineKeyboardButton>()
        keyboardButtonsRow.add(buttonUz)
        keyboardButtonsRow.add(buttonRu)
        val rowList = ArrayList<ArrayList<InlineKeyboardButton>>()
        rowList.add(keyboardButtonsRow)
        keyboard.keyboard = rowList as List<MutableList<InlineKeyboardButton>>


        try {
            execute(
                SendMessage
                    .builder()
                    .chatId(message.chatId.toString())
                    .parseMode(ParseMode.MARKDOWN)
                    .text("Assalamu alaykum Fanlar akademiyasining qayta aloqa botiga xush kelibsiz !\nTilni tanlang")
                    .replyMarkup(keyboard)
                    .build()
            )
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

    override fun onUpdateReceived(update: Update?) {

        if (update!!.hasMessage() && update.message.hasText()) {

            val messageText = update.message.text
            val command = update.message

            when (messageText) {
                "/start" -> {
                    startAnswer(command)
                }

                "Murojaat yuborish" -> {
                    sendAnApplication(command)
                }
                "Rahbar" -> {
                    application(command)
                }


                else -> {
                    try {
                        execute(
                            SendMessage
                                .builder()
                                .chatId(command.chatId.toString())
                                .parseMode(ParseMode.MARKDOWN)
                                .text("Noto'g'ri so'rov")
                                .build()
                        )
                    } catch (e: TelegramApiException) {
                        e.printStackTrace()
                    }
                }
            }

        } else if (update.hasCallbackQuery()) {
            showMenus(update.callbackQuery.message)
        }
    }

    private fun application(command: Message?) {

        if (command != null){
            try {
                execute(
                    SendMessage
                        .builder()
                        .chatId(command.chatId.toString())
                        .parseMode(ParseMode.MARKDOWN)
                        .replyMarkup(null)
                        .text("Familiya, ism-sharifingizni yuboring")
                        .build()
                )
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    }

    private fun sendAnApplication(command: Message?) {
        val replyKeyboardMarkup = ReplyKeyboardMarkup()
        replyKeyboardMarkup.resizeKeyboard = true
        replyKeyboardMarkup.selective = true
        val keyboardRowList = ArrayList<KeyboardRow>()
        val keyboardRowOne = KeyboardRow()
        val keyboardButtonOne = KeyboardButton()
        val keyboardRowTwo = KeyboardRow()
        val keyboardButtonTwo = KeyboardButton()
        val keyboardRowThree = KeyboardRow()
        val keyboardButtonThree = KeyboardButton()
        val keyboardRowFour = KeyboardRow()
        val keyboardButtonFour = KeyboardButton()
        val keyboardRowFive = KeyboardRow()
        val keyboardButtonFive = KeyboardButton()

        keyboardButtonOne.text = "Rahbar"
        keyboardButtonTwo.text = "Bosh ilmiy kotib"
        keyboardButtonThree.text = "Vitse Prezidentlar"
        keyboardButtonFour.text = "Kadrlar bo'limi"
        keyboardButtonFive.text = "Boshqa masalalar"
        keyboardRowOne.add(keyboardButtonOne)
        keyboardRowTwo.add(keyboardButtonTwo)
        keyboardRowThree.add(keyboardButtonThree)
        keyboardRowFour.add(keyboardButtonFour)
        keyboardRowFive.add(keyboardButtonFive)

        keyboardRowList.add(keyboardRowOne)
        keyboardRowList.add(keyboardRowTwo)
        keyboardRowList.add(keyboardRowThree)
        keyboardRowList.add(keyboardRowFour)
        keyboardRowList.add(keyboardRowFive)
        replyKeyboardMarkup.keyboard = keyboardRowList
        try {
            execute(
                SendMessage
                    .builder()
                    .chatId(command?.chatId.toString())
                    .parseMode(ParseMode.MARKDOWN)
                    .text("Dovom e'tamiz")
                    .replyMarkup(replyKeyboardMarkup)
                    .build()
            )
        } catch (e: TelegramApiException) {
            e.printStackTrace()

        }
    }

    private fun startAnswer(command: Message?) {
        if (command != null) {
            sendWithoutUrl(command)
        }
    }

    private fun showMenus(command: Message?) {
        val replyKeyboardMarkup = ReplyKeyboardMarkup()
        replyKeyboardMarkup.resizeKeyboard = true
        replyKeyboardMarkup.selective = true
        val keyboardRowList = ArrayList<KeyboardRow>()
        val keyboardRowOne = KeyboardRow()
        val keyboardButtonOne = KeyboardButton()
        val keyboardRowTwo = KeyboardRow()
        val keyboardButtonTwo = KeyboardButton()
        val keyboardRowThree = KeyboardRow()
        val keyboardButtonThree = KeyboardButton()
        val keyboardRowFour = KeyboardRow()
        val keyboardButtonFour = KeyboardButton()

        keyboardButtonOne.text = "Murojaat yuborish"
        keyboardButtonTwo.text = "So'rovnoma"
        keyboardButtonThree.text = "Bog'lanish"
        keyboardButtonFour.text = "Veb saytga o'tish"
        keyboardRowOne.add(keyboardButtonOne)
        keyboardRowTwo.add(keyboardButtonTwo)
        keyboardRowThree.add(keyboardButtonThree)
        keyboardRowFour.add(keyboardButtonFour)

        keyboardRowList.add(keyboardRowOne)
        keyboardRowList.add(keyboardRowTwo)
        keyboardRowList.add(keyboardRowThree)
        keyboardRowList.add(keyboardRowFour)
        replyKeyboardMarkup.keyboard = keyboardRowList
        try {
            execute(
                SendMessage
                    .builder()
                    .chatId(command?.chatId.toString())
                    .parseMode(ParseMode.MARKDOWN)
                    .text("Dovom e'tamiz")
                    .replyMarkup(replyKeyboardMarkup)
                    .build()
            )
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

}