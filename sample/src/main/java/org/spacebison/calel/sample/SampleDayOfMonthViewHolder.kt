package org.spacebison.calel.sample

import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.spacebison.calel.DayOfMonthViewHolder
import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.YearMonth
import org.threeten.bp.Duration

class SampleDayOfMonthViewHolder(parent: ViewGroup) : DayOfMonthViewHolder(parent, R.layout.item_day) {

    private val dayText = itemView as TextView

    override fun bind(date: LocalDate, month: YearMonth) {
        dayText.apply {
            text = date.dayOfMonth.toString()
            setTextColor(
                ContextCompat.getColor(
                    context,
                    if (date == LocalDate.now()) {
                        android.R.color.holo_red_dark
                    } else {
                        android.R.color.black
                    }
                )
            )

            val firstDayOfMonth = month.atDay(1)
            val lastDayOfMonth = month.atEndOfMonth()

            alpha =
                if (!date.isBefore(firstDayOfMonth) &&
                    !date.isAfter(lastDayOfMonth)) {
                    1f
                } else {
                    val daysOutsideOfMonth =
                        sequenceOf(
                            Duration.between(date, lastDayOfMonth),
                            Duration.between(date, lastDayOfMonth))
                            .min()!!
                            .toDays()

                    0.5f - daysOutsideOfMonth * 0.05f
                }
        }
    }

}