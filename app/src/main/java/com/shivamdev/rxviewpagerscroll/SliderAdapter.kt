package com.shivamdev.rxviewpagerscroll

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by shivam on 15/6/17.
 */
class SliderAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    val imagesArray = listOf(R.drawable.image1, R.drawable.image2,
            R.drawable.image3, R.drawable.image4, R.drawable.image5)

    override fun getItem(position: Int): Fragment {
        return SliderFragment.newInstance(imagesArray[position])
    }

    override fun getCount(): Int {
        return 5
    }
}