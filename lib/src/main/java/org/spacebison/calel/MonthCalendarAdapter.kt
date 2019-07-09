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

/**
 * Basic calendar adapter.
 *
 * @param VH Type of ViewHolder that displays a single date
 */
abstract class MonthCalendarAdapter<VH : DayOfMonthViewHolder> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var locale: Locale = Locale.getDefault()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private val weekFields = WeekFields.of(locale)

    /** The first day of week. Defaults to [locale]. */
    var firstDayOfWeek: DayOfWeek = weekFields.firstDayOfWeek
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /** The current month. Defaults to actual current month. */
    var month: YearMonth = YearMonth.now()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /** The last day of week. */
    val lastDayOfWeek: DayOfWeek get() = firstDayOfWeek - 1

    /**
     * The first day visible in the calendar.
     *
     * Note that in most cases this is not the same as the first day of the [month].
     */
    val firstVisibleDay: LocalDate get() = month.atDay(1).with(TemporalAdjusters.previousOrSame(firstDayOfWeek))

    /**
     * The last day visible in the calendar.
     *
     * Note that in most cases this is not the same as the last day of the [month].
     */
    val lastVisibleDay: LocalDate get() = month.atEndOfMonth().with(TemporalAdjusters.nextOrSame(lastDayOfWeek))

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, DayOfWeek.values().size)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = ChronoUnit.DAYS.between(firstVisibleDay, lastVisibleDay).toInt() + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindMonthDayViewHolder(holder as VH, position)
    }

    protected open fun onBindMonthDayViewHolder(holder: VH, day: LocalDate, month: YearMonth) {
        holder.bind(day, month)
    }

    protected fun bindMonthDayViewHolder(holder: VH, position: Int) {
        onBindMonthDayViewHolder(holder, firstVisibleDay.plusDays(position.toLong()), month)
    }
}