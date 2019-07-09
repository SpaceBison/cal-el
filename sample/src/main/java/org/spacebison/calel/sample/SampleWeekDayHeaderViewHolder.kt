package org.spacebison.calel.sample

import android.view.ViewGroup
import android.widget.TextView
import org.spacebison.calel.WeekDayHeaderViewHolder
import org.spacebison.calel.sample.format.TextStyle
import org.spacebison.calel.time.DayOfWeek
import org.spacebison.calel.time.YearMonth
import java.util.*

class SampleWeekDayHeaderViewHolder(parent: ViewGroup) :
    WeekDayHeaderViewHolder(parent, R.layout.item_week) {

    private val weekText = itemView as TextView

    override fun bind(dayOfWeek: DayOfWeek, month: YearMonth) {
        weekText.text = dayOfWeek.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault())
    }

}