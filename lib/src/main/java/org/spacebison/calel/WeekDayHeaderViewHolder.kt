package org.spacebison.calel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import org.spacebison.calel.time.DayOfWeek
import org.spacebison.calel.time.YearMonth

abstract class WeekDayHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup, @LayoutRes layout: Int) :
            this(LayoutInflater.from(parent.context).inflate(layout, parent, false))

    /**
     * @param dayOfWeek Day of week
     * @param month Current month
     */
    abstract fun bind(dayOfWeek: DayOfWeek, month: YearMonth)
}