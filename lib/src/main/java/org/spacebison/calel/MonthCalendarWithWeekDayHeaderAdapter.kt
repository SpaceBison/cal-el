package org.spacebison.calel

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.spacebison.calel.time.DayOfWeek

/**
 * A [MonthCalendarAdapter] with week day column headers.
 *
 * @param DVH Date ViewHolder type
 * @param WVH Week day header ViewHolder type
 */
abstract class MonthCalendarWithWeekDayHeaderAdapter<DVH : DayOfMonthViewHolder, WVH : WeekDayHeaderViewHolder> :
    MonthCalendarAdapter<DVH>() {

    companion object {
        protected object ViewType {
            const val DAY_OF_MONTH = 0
            const val DAY_OF_WEEK = 1
        }

        protected val daysOfWeekCount = DayOfWeek.values().size
    }

    abstract fun onCreateMonthDayViewHolder(parent: ViewGroup): DVH

    abstract fun onCreateWeekDayViewHolder(parent: ViewGroup): WVH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ViewType.DAY_OF_MONTH -> onCreateMonthDayViewHolder(parent)
            ViewType.DAY_OF_WEEK -> onCreateWeekDayViewHolder(parent)
            else -> throw IllegalStateException("Unsupported view type: $viewType")
        }

    override fun getItemCount(): Int = super.getItemCount() + daysOfWeekCount

    override fun getItemViewType(position: Int): Int =
        if (position < daysOfWeekCount) ViewType.DAY_OF_WEEK else ViewType.DAY_OF_MONTH

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ViewType.DAY_OF_MONTH -> bindMonthDayViewHolder(holder as DVH, position - daysOfWeekCount)
            ViewType.DAY_OF_WEEK -> bindWeekDayViewHolder(holder as WVH, position)
        }
    }

    open protected fun onBindWeekDayViewHolder(holder: WVH, dayOfWeek: DayOfWeek) {
        holder.bind(dayOfWeek, month)
    }

    protected fun bindWeekDayViewHolder(holder: WVH, position: Int) {
        onBindWeekDayViewHolder(holder, firstDayOfWeek.plus(position.toLong()))
    }
}