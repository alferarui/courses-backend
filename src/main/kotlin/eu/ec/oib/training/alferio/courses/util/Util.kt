package eu.ec.oib.training.alferio.courses.util

import java.time.LocalDate

class Util {
    companion object{
        fun getStarDate1970(ld: LocalDate): Double {
            val currentYear = ld.year
            val dayOfYear = ld.dayOfYear
            val totalDaysInYear = ld.lengthOfYear()
            val dayOfYearFraction = dayOfYear.toDouble() / totalDaysInYear
            return (currentYear - 1970) + (dayOfYearFraction)
        }

    }
}