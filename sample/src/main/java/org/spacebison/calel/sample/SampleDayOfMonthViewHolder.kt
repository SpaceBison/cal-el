package org.spacebison.calel.sample

import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.spacebison.calel.DayOfMonthViewHolder
import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.YearMonth

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

            alpha =
                if (!date.isBefore(month.atDay(1)) &&
                    !date.isAfter(month.atEndOfMonth())) {
                    1f
                } else {
                    0.3f
                }
        }
    }

}