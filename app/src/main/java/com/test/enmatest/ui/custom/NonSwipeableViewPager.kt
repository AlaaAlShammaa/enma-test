package com.test.enmatest.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.duolingo.open.rtlviewpager.RtlViewPager


class NonSwipeableViewPager : RtlViewPager {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return false
    }
}