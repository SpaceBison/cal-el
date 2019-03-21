package org.spacebison.calel

import android.view.ViewGroup
import org.spacebison.calel.time.DayOfWeek

abstract class WeekDayHeaderCalendarAdapter<DVH : MonthDayViewHolder, WVH : WeekDayViewHolder> :
    CalendarAdapter<DVH>() {

    companion object {
        protected object ViewType {
            const val DAY_OF_MONTH = 0
            const val DAY_OF_WEEK = 1
        }

        protected val daysOfWeekCount = DayOfWeek.values().size
    }

    abstract fun onCreateMonthDayViewHolder(parent: ViewGroup): DVH

    abstract fun onCreateWeekDayViewHolder(parent: ViewGroup): WVH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarItemViewHolder =
        when (viewType) {
            ViewType.DAY_OF_MONTH -> onCreateMonthDayViewHolder(parent)
            ViewType.DAY_OF_WEEK -> onCreateWeekDayViewHolder(parent)
            else -> throw IllegalStateException("Unsupported view type: $viewType")
        }

    override fun getItemCount(): Int = super.getItemCount() + daysOfWeekCount

    override fun getItemViewType(position: Int): Int =
        if (position < daysOfWeekCount) ViewType.DAY_OF_WEEK else ViewType.DAY_OF_MONTH

    override fun onBindViewHolder(holder: CalendarItemViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ViewType.DAY_OF_MONTH -> bindMonthDayViewHolder(holder, position - daysOfWeekCount)
            ViewType.DAY_OF_WEEK -> bindWeekDayViewHolder(holder, position)
        }
    }

    open protected fun onBindWeekDayViewHolder(holder: WVH, dayOfWeek: DayOfWeek) {
        holder.bind(dayOfWeek, yearMonth)
    }

    protected fun bindWeekDayViewHolder(holder: CalendarItemViewHolder, position: Int) {
        onBindWeekDayViewHolder(holder as WVH, firstDayOfWeek.plus(position.toLong()))
    }
}