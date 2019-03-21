package org.spacebison.calel.sample

import android.view.ViewGroup
import org.spacebison.calel.WeekDayHeaderCalendarAdapter

class SampleCalendarAdapter : WeekDayHeaderCalendarAdapter<SampleMonthDayViewHolder, SampleWeekDayViewHolder>() {
    override fun onCreateMonthDayViewHolder(parent: ViewGroup): SampleMonthDayViewHolder =
        SampleMonthDayViewHolder(parent)

    override fun onCreateWeekDayViewHolder(parent: ViewGroup): SampleWeekDayViewHolder =
        SampleWeekDayViewHolder(parent)
}