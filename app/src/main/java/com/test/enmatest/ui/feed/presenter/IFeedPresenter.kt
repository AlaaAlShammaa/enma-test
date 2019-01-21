package com.test.enmatest.ui.feed.presenter

import com.test.enmatest.ui.base.presenter.IPresenter
import com.test.enmatest.ui.feed.adapter.FeedAdapter
import com.test.enmatest.ui.feed.interactor.IFeedInteractor
import com.test.enmatest.ui.feed.view.IFeedView

interface IFeedPresenter<V : IFeedView, I : IFeedInteractor> : IPresenter<V, I>, FeedAdapter.Callback {
    fun getPosts(query: String?)
}
