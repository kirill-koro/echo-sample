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
            content = "The regional conflict has escalated into a multifaceted humanitarian " +
                    "crisis. Overnight, Israeli defense systems intercepted a barrage of " +
                    "long-range missiles launched from Iranian territory, while drone activity " +
                    "spiked near the US Embassy in Baghdad. Global leaders are calling for an " +
                    "immediate ceasefire as the Lebanese Ministry of Health reports over one " +
                    "million citizens have been internally displaced. Aid corridors remain " +
                    "choked, and the UN has warned that food and medical supplies in the " +
                    "southern districts will be exhausted within 48 hours if sea routes " +
                    "remain blockaded.",
        ),
        TopicDto.create(
            id = 1,
            title = "Interest Rates Steady Amid War Shock",
            summary = "The Federal Reserve is expected to keep interest rates at current levels " +
                    "today. Policymakers are navigating a \"bind\" as skyrocketing energy prices, " +
                    "triggered by the conflict in the Persian Gulf, threaten to upend previous " +
                    "inflation and growth forecasts.",
            content = "Federal Reserve Chair Jerome Powell confirmed today that the central " +
                    "bank will maintain current interest rates, citing \"extraordinary " +
                    "geopolitical uncertainty.\" The decision comes as Brent Crude surged " +
                    "past \$140 a barrel following supply disruptions in the Persian Gulf. " +
                    "Economists are concerned that the \"war shock\" is creating a " +
                    "stagflationary environment—where growth slows but inflation remains " +
                    "sticky due to energy costs. The Fed's \"dot plot\" now suggests no further " +
                    "hikes this year, a sharp pivot from January's hawkish stance.",
        ),
        TopicDto.create(
            id = 2,
            title = "Asia Returns to Coal",
            summary = "With the Strait of Hormuz effectively closed and Qatari production halted " +
                    "due to regional fighting, nearly 20% of the world’s liquefied natural gas " +
                    "(LNG) supply is offline. Major Asian importers are forced to restart coal " +
                    "plants to maintain power stability.",
            content = "The closure of the Strait of Hormuz has sent shockwaves through the " +
                    "global energy grid. Japan and South Korea, which rely heavily on Qatari " +
                    "gas, have begun the emergency reactivation of decommissioned coal-fired " +
                    "power plants to prevent rolling blackouts. While environmental groups decry " +
                    "the move as a massive setback for 2030 climate goals, energy ministers argue" +
                    " that \"grid stability is the immediate priority.\" The shift highlights a " +
                    "fragile global dependence on narrow maritime corridors for the world's " +
                    "transition fuels.\n",
        ),
        TopicDto.create(
            id = 3,
            title = "Israeli Strikes and US Resignations",
            summary = "Following the killing of top Iranian security official Ali Larijani, a " +
                    "key US intelligence advisor has resigned in protest of the ongoing war.",
            content = "The assassination of Ali Larijani, a top-tier Iranian security strategist," +
                    " via a precision drone strike has fractured the international diplomatic " +
                    "community. In Washington, the move prompted the high-profile resignation " +
                    "of the Chief Intelligence Advisor for the Near East, who cited " +
                    "\"unreconciled differences regarding escalatory tactics.\" On Capitol Hill, " +
                    "domestic policy continues to churn as a bipartisan coalition pushes the " +
                    "\"Healthcare Hero Act,\" aiming to fast-track permanent residency for " +
                    "foreign-born medical professionals to address a critical nursing shortage.",
        ),
        TopicDto.create(
            id = 4,
            title = "The New Fraud Wave",
            summary = "The UN has issued a global wake-up call regarding organized fraud using " +
                    "voice cloning and deepfakes.",
            content = "Cybercrime has entered a \"hyper-realistic\" phase. Using less than " +
                    "30 seconds of high-quality audio, scammers are now using AI to clone " +
                    "voices of family members or corporate executives to authorize fraudulent " +
                    "transfers. The UN's Cyber Task Force reported a 400% increase in \"Business" +
                    " Email Compromise\" (BEC) cases where deepfake video calls were used to " +
                    "impersonate CEOs. Authorities are urging the public to adopt \"safe words\"" +
                    " for family communications and multi-factor biometric authentication for " +
                    "all financial transactions.",
        ),
        TopicDto.create(
            id = 5,
            title = "Athletic Lifestyle Struggles in Europe",
            summary = "Recent industry reports indicate that athletic lifestyle products are " +
                    "becoming a \"tough sell\" across European markets as consumer spending shifts." +
                    " Simultaneously, London Fashion Week designers are pivoting toward " +
                    "\"experiential\" trade shows.",
            content = "The \"Sneakerhead\" era is cooling off. Market data from Paris and Milan" +
                    " indicates a sharp decline in sales for high-end athletic lifestyle brands, " +
                    "as consumers pivot toward \"Quiet Utility\" and vintage-inspired tailored " +
                    "wear. This shift has forced major retailers to rethink their inventory. " +
                    "Meanwhile, London Fashion Week has transformed into a series of " +
                    "\"experiential pop-ups,\" where the focus is on garment longevity and " +
                    "repair workshops rather than seasonal mass production, reflecting a more " +
                    "conscious, post-consumerist mindset.",
        ),
    )

    @Suppress("MagicNumber")
    suspend fun getTopics(query: String): List<TopicDto> {
        delay(600.milliseconds)
        return if (query == "F") emptyList() else data
    }

    suspend fun getTopic(id: Int): TopicDto {
        delay(600.milliseconds)
        return data[id]
    }
}
