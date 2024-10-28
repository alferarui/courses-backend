package eu.ec.oib.training.alferio.courses.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import java.util.function.Function
import java.util.stream.Collectors

class RandomGenerators {
    companion object {

        fun randomVowel(): String {
            val vowels = "aeiou"
            return vowels[(Math.random() * vowels.length).toInt()].toString() + ""
        }

        fun randomConsonant(): String {
            val consonants = "bcdfgjlmnprstuvz"
            return consonants[(Math.random() * consonants.length).toInt()].toString() + ""
        }

        enum class SyllableModel(val value: String) {
            VCV("VCV"),
            CVC("CVC"),
            CV("CV"),
            VC("VC");

            companion object {
                fun randomModel(): SyllableModel {
                    val models = arrayOf(VCV, CVC, CV, VC)
                    return models[(Math.random() * models.size).toInt()]
                }
            }
        }

        fun randomSyllable(model: SyllableModel): String {
            return model.value.split("".toRegex()).joinToString("") { chr: String? ->
                when (chr) {
                    "V" -> randomVowel()
                    else -> randomConsonant()
                }
            }
        }

        fun randomWord(syllableCount: Int): String {
            return (1..syllableCount.toLong())
                .joinToString("") { ix: Long? -> randomSyllable(SyllableModel.randomModel()) }
        }
        fun <T> randomItem(tokens: List<T>): T {
            return tokens[(Math.random() * tokens.size).toInt()]
        }

        var commonNames: String = "John, Mary, James, Patricia, Robert, Jennifer, Michael, Linda, William, Elizabeth"
        fun randomCommonName() = randomItem(commonNames.split(", ".toRegex()).dropLastWhile { it.isEmpty() })

        var familyNames: String = "Smith, Johnson, Brown, Taylor, Anderson, Thomas, Jackson, White, Harris, Martin"
        fun randomFamilyName() = randomItem(familyNames.split(", ".toRegex()).dropLastWhile { it.isEmpty() })

        var cities: String =
            "New York, Los Angeles, Chicago, Houston, Phoenix, Philadelphia, San Antonio, San Diego, Dallas, San Jose"

        fun randomCity() = randomItem(cities.split(", ".toRegex()).dropLastWhile { it.isEmpty() })

        var streetNames: String =
            "Main St, High St, Elm St, Oak St, Maple Ave, Cedar Rd, Pine Dr, Birch Ln, Walnut Blvd, Cherry Cir"

        fun randomStreetName() = randomItem(streetNames.split(", ".toRegex()).dropLastWhile { it.isEmpty() })

        var companyNames: String = "Google, Microsoft, Apple, Amazon, Facebook, IBM, Oracle, Intel, Tesla, Adobe"
        fun randomCompanyName() = randomItem(companyNames.split(", ".toRegex()).dropLastWhile { it.isEmpty() })

        var domainTLDs: String = "com, org, net, io, co, us, co.uk, co.ca, de, co.au, info, tw"
        fun randomDomainTLD() = randomItem(domainTLDs.split(", ".toRegex()).dropLastWhile { it.isEmpty() })

        var languageId: String = "en, es, fr, de, zh, ja, us, ar, pt, it"
        fun randomLanguageId() = randomItem(languageId.split(", ".toRegex()).dropLastWhile { it.isEmpty() })


        fun randomLocalDate(start: String?, end: String?): LocalDate {
            val startDate = LocalDate.parse(start, DateTimeFormatter.ISO_LOCAL_DATE)
            val endDate = LocalDate.parse(end, DateTimeFormatter.ISO_LOCAL_DATE)
            val daysBetween = ChronoUnit.DAYS.between(startDate, endDate)
            println(daysBetween)
            val randomDays = ThreadLocalRandom.current().nextLong(0, daysBetween + 1)
            return startDate.plusDays(randomDays)
        }
        fun randomPhoneNumber(): String {
            val random = Random()
            // Generate a random 10-digit number
            val areaCode = random.nextInt(900) + 100 // Ensure area code is 3 digits
            val centralOfficeCode = random.nextInt(900) + 100 // Ensure central office code is 3 digits
            val lineNumber = random.nextInt(10000) // 4-digit line number

            return String.format("(%03d) %03d-%04d", areaCode, centralOfficeCode, lineNumber)
        }
        fun randomZipCode(): String {
            val random = Random()
            val zipCode = random.nextInt(90000) + 10000 // Ensures a 5-digit zip code between 10000 and 99999
            return String.format("%05d", zipCode)
        }
        val descriptions: Array<String> = arrayOf(
            "A thrilling tale of procrastination and coffee.",
            "The epic journey from couch to fridge.",
            "Adventures in avoiding laundry since 2023.",
            "An unintentional expert in the art of napping.",
            "Mastering the art of binge-watching like a pro.",
            "A pizza lover's guide to surviving Mondays.",
            "Running late: the autobiography.",
            "Certified cat video connoisseur.",
            "Living life one meme at a time.",
            "Expert at talking to pets like they understand.",
            "When life gives you lemons, make a mess in the kitchen and order takeout.",
            "The art of dodging phone calls: a masterclass in silent mode.",
            "Eating chips like nobody’s watching... even when everybody's watching.",
            "A highly caffeinated adventure through an unfinished to-do list.",
            "Defeating Wi-Fi dead zones, one awkward stance at a time.",
            "Conquering Mondays with nothing but sarcasm and a cold coffee.",
            "Accidentally becoming the nap champion of the world.",
            "Unlocking the mysteries of adulting, but deciding to take a nap instead.",
            "Getting lost in a grocery store because of an overcomplicated shopping list.",
            "Doing yoga once and now spiritually connected to snacks."
        )

        fun randomDescription(): String {
            val random = Random()
            return descriptions.get(random.nextInt(descriptions.size))
        }
        val titles: Array<String> = arrayOf(
            "Captain Procrastination: The Saga Continues",
            "Lord of the Fries: The Snack Returns",
            "The Chronicles of Naplandia",
            "Game of Scones: A Baking Adventure",
            "Harry Potter and the Cup of Coffee",
            "Star Woes: The Internet Strikes Back",
            "The Hitchhiker's Guide to Monday Mornings",
            "The Fellowship of the Remote",
            "Mission Impossible: Finding Clean Socks",
            "The Great Escape: Dodging Responsibilities",
            "Jurassic Bark: The Tale of a Dog's Backyard Adventures",
            "The Walking Dad: A Journey to Bedtime",
            "Indiana Jones and the Last Slice of Pizza",
            "The Office Escape Plan: Dodging Meetings",
            "To-Do List of the Dead: Tasks That Will Never Be Completed",
            "Mission: Procrastination – The Never-Ending Task",
            "The Fast and the Curious: Why Did I Walk Into This Room?",
            "Pirates of the Couch: The Remote’s Hidden Treasure",
            "The Lord of the Chores: Fellowship of Laundry",
            "Marvel's Latest Hero: Captain Clumsy and the Case of Spilled Coffee"
        )

        fun randomTitle(): String {
            val random = Random()
            return titles.get(random.nextInt(titles.size))
        }
    }
}