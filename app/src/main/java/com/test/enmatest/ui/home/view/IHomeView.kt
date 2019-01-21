package com.test.enmatest.ui.home.view

import com.test.enmatest.ui.base.view.IView

interface IHomeView : IView {
    fun customizeBottomNavView()
    fun showToolbarProgress()
    fun hideToolbarProgress()
    fun launchSearch()
}
