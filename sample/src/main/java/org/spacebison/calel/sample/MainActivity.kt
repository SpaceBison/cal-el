package org.spacebison.calel.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.spacebison.calel.time.YearMonth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.apply {
            adapter = CalendarPagerAdapter(supportFragmentManager)
            currentItem = CalendarPagerAdapter.POSITION_ZERO
        }
    }

    private class CalendarPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        companion object {
            const val POSITION_ZERO = Int.MAX_VALUE / 2
        }

        override fun getItem(position: Int): Fragment =
            MonthFragment.getInstance(YearMonth.now().plusMonths((position - POSITION_ZERO).toLong()))

        override fun getCount(): Int = Int.MAX_VALUE
    }
}
