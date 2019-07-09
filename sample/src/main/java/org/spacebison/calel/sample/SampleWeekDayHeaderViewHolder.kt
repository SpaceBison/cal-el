package org.spacebison.calel.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import org.spacebison.calel.WeekDayHeaderViewHolder
import org.spacebison.calel.time.DayOfWeek
import org.spacebison.calel.time.YearMonth
import org.spacebison.calel.sample.format.TextStyle
import java.util.*

class SampleWeekDayHeaderViewHolder(parent: ViewGroup) :
    WeekDayHeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_week, parent, false)) {

    private val weekText = itemView as TextView

    override fun bind(dayOfWeek: DayOfWeek, month: YearMonth) {
        weekText.text = dayOfWeek.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault())
    }

}