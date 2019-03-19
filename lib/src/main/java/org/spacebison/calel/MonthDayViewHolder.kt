package org.spacebison.calel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.YearMonth

abstract class MonthDayViewHolder(itemView: View)
    : CalendarItemViewHolder(itemView) {

    abstract fun bind(date: LocalDate, yearMonth: YearMonth)
}