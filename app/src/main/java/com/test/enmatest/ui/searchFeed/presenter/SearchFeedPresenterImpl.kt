package com.test.enmatest.ui.searchFeed.presenter

import com.test.enmatest.ui.base.presenter.BasePresenterImpl
import com.test.enmatest.ui.searchFeed.interactor.ISearchFeedInteractor
import com.test.enmatest.ui.searchFeed.view.ISearchFeedView
import com.test.enmatest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SearchFeedPresenterImpl<V : ISearchFeedView, I : ISearchFeedInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenterImpl<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), ISearchFeedPresenter<V, I> {

    override fun onBackClicked() {
        getView()?.goBack()
    }

    override fun onSearchClicked(query: String) {
        getView()?.searchByQuery(query)
    }
}
