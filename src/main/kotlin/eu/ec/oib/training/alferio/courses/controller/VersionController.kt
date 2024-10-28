package eu.ec.oib.training.alferio.courses.controller

import eu.ec.oib.training.alferio.courses.Version
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VersionController {
    @GetMapping("/version")
    fun getVersion(): Version {
        return Version()
    }
}