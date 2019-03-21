package org.spacebison.calel

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.spacebison.calel.time.DayOfWeek
import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.YearMonth
import org.spacebison.calel.time.temporal.ChronoUnit
import org.spacebison.calel.time.temporal.TemporalAdjusters
import org.spacebison.calel.time.temporal.WeekFields
import java.util.*

abstract class CalendarAdapter<VH : MonthDayViewHolder> : RecyclerView.Adapter<CalendarItemViewHolder>() {

    var firstDayOfWeek: DayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var yearMonth: YearMonth = YearMonth.now()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    val lastDayOfWeek get() = firstDayOfWeek - 1
    val firstVisibleDay get() = yearMonth.atDay(1).with(TemporalAdjusters.previousOrSame(firstDayOfWeek))
    val lastVisibleDay get() = yearMonth.atEndOfMonth().with(TemporalAdjusters.nextOrSame(lastDayOfWeek))

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, DayOfWeek.values().size).apply {
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = ChronoUnit.DAYS.between(firstVisibleDay, lastVisibleDay).toInt() + 1

    override fun onBindViewHolder(holder: CalendarItemViewHolder, position: Int) {
        bindMonthDayViewHolder(holder, position)
    }

    open protected fun onBindMonthDayViewHolder(holder: VH, day: LocalDate, yearMonth: YearMonth) {
        holder.bind(day, yearMonth)
    }

    protected fun bindMonthDayViewHolder(holder: CalendarItemViewHolder, position: Int) {
        onBindMonthDayViewHolder(holder as VH, firstVisibleDay.plusDays(position.toLong()), yearMonth)
    }
}