package org.spacebison.calel.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.spacebison.calel.WeekDayViewHolder
import org.spacebison.calel.time.DayOfWeek
import org.spacebison.calel.time.LocalDate
import org.spacebison.calel.time.YearMonth
import org.threeten.bp.format.TextStyle
import java.util.*

class SampleWeekDayViewHolder(parent: ViewGroup) :
    WeekDayViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_week, parent, false)) {

    private val weekText = itemView as TextView

    override fun bind(dayOfWeek: DayOfWeek, yearMonth: YearMonth) {
        weekText.text = dayOfWeek.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault())
    }

}