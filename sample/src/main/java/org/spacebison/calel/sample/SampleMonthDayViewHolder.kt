package org.spacebison.calel.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.spacebison.calel.MonthDayViewHolder
import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.YearMonth

class SampleMonthDayViewHolder(parent: ViewGroup) :
    MonthDayViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_day, parent, false)) {

    private val dayText = itemView as TextView

    override fun bind(date: LocalDate, yearMonth: YearMonth) {
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
                if (!date.isBefore(yearMonth.atDay(1)) &&
                    !date.isAfter(yearMonth.atEndOfMonth())) {
                    1f
                } else {
                    0.3f
                }
        }
    }

}