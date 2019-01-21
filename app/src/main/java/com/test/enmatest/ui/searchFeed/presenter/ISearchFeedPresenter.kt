package com.test.enmatest.ui.searchFeed.presenter

import com.test.enmatest.ui.base.presenter.IPresenter
import com.test.enmatest.ui.searchFeed.interactor.ISearchFeedInteractor
import com.test.enmatest.ui.searchFeed.view.ISearchFeedView

interface ISearchFeedPresenter<V : ISearchFeedView, I : ISearchFeedInteractor> : IPresenter<V, I> {
    fun onBackClicked()
    fun onSearchClicked(query: String)
}
