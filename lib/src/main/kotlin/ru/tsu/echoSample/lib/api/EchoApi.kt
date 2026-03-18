package ru.tsu.echoSample.lib.api

import kotlinx.coroutines.delay
import ru.tsu.echoSample.lib.model.TopicDto
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

class EchoApi @Inject constructor() {
    @Suppress("Indentation")
    private val data = listOf(
        TopicDto.create(
            id = 0,
            title = "War Enters 19th Day",
            summary = "Tensions reach a critical peak as missiles from Iran are intercepted over " +
                    "the West Bank and drone attacks resume near the US Embassy in Baghdad. Global " +
                    "humanitarian agencies warn that displacement in Lebanon has now topped one " +
                    "million people.",
        ),
        TopicDto.create(
            id = 1,
            title = "Interest Rates Steady Amid War Shock",
            summary = "The Federal Reserve is expected to keep interest rates at current levels " +
                    "today. Policymakers are navigating a \"bind\" as skyrocketing energy prices, " +
                    "triggered by the conflict in the Persian Gulf, threaten to upend previous " +
                    "inflation and growth forecasts.",
        ),
        TopicDto.create(
            id = 2,
            title = "Asia Returns to Coal",
            summary = "With the Strait of Hormuz effectively closed and Qatari production halted " +
                    "due to regional fighting, nearly 20% of the world’s liquefied natural gas " +
                    "(LNG) supply is offline. Major Asian importers are forced to restart coal " +
                    "plants to maintain power stability.",
        ),
        TopicDto.create(
            id = 3,
            title = "Israeli Strikes and US Resignations",
            summary = "Following the killing of top Iranian security official Ali Larijani, a " +
                    "key US intelligence advisor has resigned in protest of the ongoing war.",
        ),
        TopicDto.create(
            id = 4,
            title = "The New Fraud Wave",
            summary = "The UN has issued a global wake-up call regarding organized fraud using " +
                    "voice cloning and deepfakes.",
        ),
        TopicDto.create(
            id = 5,
            title = "Athletic Lifestyle Struggles in Europe",
            summary = "Recent industry reports indicate that athletic lifestyle products are " +
                    "becoming a \"tough sell\" across European markets as consumer spending shifts." +
                    " Simultaneously, London Fashion Week designers are pivoting toward " +
                    "\"experiential\" trade shows.",
        ),
    )

    @Suppress("MagicNumber")
    suspend fun getTopics(query: String): List<TopicDto> {
        delay(300.milliseconds)
        return if (query == "F") emptyList() else data
    }

    suspend fun getTopic(id: Int): TopicDto {
        delay(300.milliseconds)
        return data[id]
    }
}
