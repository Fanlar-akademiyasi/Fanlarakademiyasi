import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

fun main(args: Array<String>) {

    val api = TelegramBotsApi(DefaultBotSession::class.java)
    api.registerBot(MyBot())
}