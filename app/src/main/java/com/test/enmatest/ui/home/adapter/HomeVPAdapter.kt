package com.test.enmatest.ui.home.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.test.enmatest.ui.categories.view.CategoriesFragment
import com.test.enmatest.ui.feed.view.FeedFragment

class HomeVPAdapter(fragmentManager: FragmentManager, val context: Context) :
    FragmentStatePagerAdapter(fragmentManager) {
    var mCurrentFragment: Fragment? = null

    companion object {
        const val HOME_FRAGMENT_INDEX = 0
        const val CATEGORIES_FRAGMENT_INDEX = 1
        const val ACCOUNT_FRAGMENT_INDEX = 2
        const val SETTINGS_FRAGMENT_INDEX = 3
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            HOME_FRAGMENT_INDEX -> FeedFragment.newInstance()
            CATEGORIES_FRAGMENT_INDEX -> CategoriesFragment.newInstance()
            else -> Fragment()
        }
    }

    override fun getCount(): Int = 4

    override fun setPrimaryItem(container: ViewGroup, position: Int, object1: Any) {
        if (mCurrentFragment != object1) {
            mCurrentFragment = object1 as Fragment
        }
        super.setPrimaryItem(container, position, object1)
    }

}