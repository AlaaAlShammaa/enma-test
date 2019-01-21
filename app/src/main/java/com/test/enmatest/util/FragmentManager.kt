package com.test.enmatest.util


import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.test.enmatest.R


internal fun FragmentManager.removeFragment(tag: String,
                                            slideIn: Int = R.anim.slide_left,
                                            slideOut: Int = R.anim.slide_right) {
    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(this.findFragmentByTag(tag)!!)
            .commitNow()
}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String?,
                                         slideIn: Int = R.anim.slide_left,
                                         slideOut: Int = R.anim.slide_right) {
    this.beginTransaction().disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .add(containerViewId, fragment, tag)
            .commit()
}

internal fun FragmentManager.replaceFragment(containerViewId: Int,
                                             fragment: Fragment,
                                             tag: String,
                                             slideIn: Int = R.anim.slide_left,
                                             slideOut: Int = R.anim.slide_right) {
    this.beginTransaction()
            .setCustomAnimations(slideIn, slideOut, slideIn, slideOut)
            .replace(containerViewId, fragment, tag)
            .addToBackStack(tag)
            .commit()
}

internal fun FragmentManager.replaceFragmentWithoutBackStack(containerViewId: Int,
                                                             fragment: Fragment,
                                                             tag: String,
                                                             slideIn: Int = R.anim.slide_left,
                                                             slideOut: Int = R.anim.slide_right) {
    this.beginTransaction()
            .setCustomAnimations(slideIn, slideOut, slideIn, slideOut)
            .replace(containerViewId, fragment, tag)
            .commit()
}

