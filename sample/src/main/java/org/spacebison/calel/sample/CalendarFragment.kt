package org.spacebison.calel.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calendar.*
import org.spacebison.calel.time.YearMonth
import org.spacebison.calel.time.format.DateTimeFormatter

class CalendarFragment : Fragment() {

    companion object {
        const val ARG_YEAR_MONTH = "year_month"

        private val headerFormat = DateTimeFormatter.ofPattern("MMMM yyyy")

        fun getInstance(yearMonth: YearMonth) =
            CalendarFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_YEAR_MONTH, yearMonth)
                }
            }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_calendar, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val yearMonth = (arguments?.getSerializable(ARG_YEAR_MONTH) as? YearMonth) ?: YearMonth.now()

        header.text = yearMonth.format(headerFormat)

        calendarRecycler.adapter = SampleMonthCalendarAdapter().apply {
            this.month = yearMonth
        }
    }
}