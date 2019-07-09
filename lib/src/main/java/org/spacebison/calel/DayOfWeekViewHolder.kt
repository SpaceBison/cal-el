package org.spacebison.calel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import org.spacebison.calel.time.LocalDate

/**
 * Represents a single date in the calendar.
 */
abstract class DayOfWeekViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup, @LayoutRes layout: Int) :
            this(LayoutInflater.from(parent.context).inflate(layout, parent, false))

    /**
     * @param date The date represented by this view
     * @param week Current week
     */
    abstract fun bind(date: LocalDate, week: YearWeek)
}