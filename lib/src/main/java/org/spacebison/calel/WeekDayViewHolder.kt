package org.spacebison.calel

import android.view.View
import org.spacebison.calel.time.DayOfWeek
import org.spacebison.calel.time.YearMonth

abstract class WeekDayViewHolder(itemView: View) : CalendarItemViewHolder(itemView) {
    abstract fun bind(dayOfWeek: DayOfWeek, yearMonth: YearMonth)
}