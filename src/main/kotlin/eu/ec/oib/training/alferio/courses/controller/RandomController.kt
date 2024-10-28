package eu.ec.oib.training.alferio.courses.controller

import eu.ec.oib.training.alferio.courses.util.RandomGenerators
import io.swagger.v3.oas.annotations.Parameter
import jakarta.websocket.server.PathParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class RandomController {


    @GetMapping("/Word/{count}")
    fun randomWord(@PathParam("count") syllableCount: Int): String {
        return RandomGenerators.randomWord(syllableCount)
    }

    @GetMapping("/CommonName")
    fun randomCommonName(): String {
        return RandomGenerators.randomCommonName()
    }

    @GetMapping("/FamilyName")
    fun randomFamilyName(): String {
        return RandomGenerators.randomFamilyName()
    }

    @GetMapping("/City")
    fun randomCity(): String {
        return RandomGenerators.randomCity()
    }

    @GetMapping("/StreetName")
    fun randomStreetName(): String {
        return RandomGenerators.randomStreetName()
    }

    @GetMapping("/CompanyName")
    fun randomCompanyName(): String {
        return RandomGenerators.randomCompanyName()
    }

    @GetMapping("/DomainTLD")
    fun randomDomainTLD(): String {
        return RandomGenerators.randomDomainTLD()
    }

    @GetMapping("/LanguageId")
    fun randomLanguageId(): String {
        return RandomGenerators.randomLanguageId()
    }

    @GetMapping("/LocalDate")
    fun randomLocalDate(@Parameter(name = "start") start: String, @Parameter(name = "end") end: String): LocalDate {
        return RandomGenerators.randomLocalDate(start, end)
    }

    @GetMapping("/PhoneNumber")
    fun randomPhoneNumber(): String {
        return RandomGenerators.randomPhoneNumber()
    }

    @GetMapping("/ZipCode")
    fun randomZipCode(): String {
        return RandomGenerators.randomZipCode()
    }

    @GetMapping("/Description")
    fun randomDescription(): String {
        return RandomGenerators.randomDescription()
    }

    @GetMapping("/Title")
    fun randomTitle(): String {
        return RandomGenerators.randomTitle()
    }
}