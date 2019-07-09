package org.spacebison.calel

import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.Year
import org.spacebison.calel.time.temporal.WeekFields
import java.util.*

data class YearWeek(
    val year: Year,
    val weekOfYear: Int,
    val weekFields: WeekFields = WeekFields.of(Locale.getDefault())) {

    companion object {
        fun now(weekFields: WeekFields = WeekFields.of(Locale.getDefault())) =
            YearWeek(Year.now(), LocalDate.now().get(weekFields.weekOfWeekBasedYear()), weekFields)
    }

}