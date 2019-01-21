package com.test.enmatest.ui.searchFeed.view

import com.test.enmatest.ui.base.view.IView

interface ISearchFeedView : IView {
    fun showToolbarProgress()
    fun hideToolbarProgress()
    fun goBack()
    fun searchByQuery(query: String)
}
