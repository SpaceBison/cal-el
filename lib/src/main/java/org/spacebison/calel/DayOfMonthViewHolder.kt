package org.spacebison.calel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.YearMonth

/**
 * Represents a single date in the calendar.
 */
abstract class DayOfMonthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup, @LayoutRes layout: Int) :
            this(LayoutInflater.from(parent.context).inflate(layout, parent, false))

    /**
     * @param date The date represented by this view
     * @param month Current month
     */
    abstract fun bind(date: LocalDate, month: YearMonth)
}