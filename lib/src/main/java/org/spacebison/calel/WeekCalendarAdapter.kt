package org.spacebison.calel

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.spacebison.calel.time.DayOfWeek
import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.temporal.ChronoUnit
import org.spacebison.calel.time.temporal.TemporalAdjusters
import org.spacebison.calel.time.temporal.WeekFields
import java.util.*

/**
 * Basic calendar adapter.
 *
 * @param VH Type of ViewHolder that displays a single date
 */
abstract class WeekCalendarAdapter<VH : DayOfWeekViewHolder> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var locale: Locale = Locale.getDefault()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /** The current month. Defaults to actual current month. */
    var week: YearWeek = YearWeek.now(WeekFields.of(locale))
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private val weekFields = week.weekFields

    /** The first day of week. Defaults to locale default. */
    var firstDayOfWeek: DayOfWeek = weekFields.firstDayOfWeek
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /** The last day of week. */
    val lastDayOfWeek: DayOfWeek get() = firstDayOfWeek - 1

    /**
     * The first day visible in the calendar.
     */
    val firstVisibleDay: LocalDate
        get() = week.year.atDay(1).plusWeeks(week.weekOfYear.toLong() - 1).with(TemporalAdjusters.previousOrSame(firstDayOfWeek))

    /**
     * The last day visible in the calendar.
     */
    val lastVisibleDay: LocalDate
        get() = week.year.atDay(1).plusWeeks(week.weekOfYear.toLong() - 1).with(TemporalAdjusters.previousOrSame(lastDayOfWeek))

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, DayOfWeek.values().size)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = ChronoUnit.DAYS.between(firstVisibleDay, lastVisibleDay).toInt() + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindMonthDayViewHolder(holder as VH, position)
    }

    protected open fun onBindMonthDayViewHolder(holder: VH, day: LocalDate, week: YearWeek) {
        holder.bind(day, week)
    }

    protected fun bindMonthDayViewHolder(holder: VH, position: Int) {
        onBindMonthDayViewHolder(holder, firstVisibleDay.plusDays(position.toLong()), week)
    }
}