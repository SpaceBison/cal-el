package org.spacebison.calel.sample

import android.view.ViewGroup
import org.spacebison.calel.MonthCalendarWithWeekDayHeaderAdapter

class SampleMonthCalendarAdapter : MonthCalendarWithWeekDayHeaderAdapter<SampleDayOfMonthViewHolder, SampleWeekDayHeaderViewHolder>() {

    override fun onCreateMonthDayViewHolder(parent: ViewGroup): SampleDayOfMonthViewHolder =
        SampleDayOfMonthViewHolder(parent)

    override fun onCreateWeekDayViewHolder(parent: ViewGroup): SampleWeekDayHeaderViewHolder =
        SampleWeekDayHeaderViewHolder(parent)
}