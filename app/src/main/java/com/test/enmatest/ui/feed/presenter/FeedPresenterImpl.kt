package com.test.enmatest.ui.feed.presenter

import com.test.enmatest.ui.base.presenter.BasePresenterImpl
import com.test.enmatest.ui.feed.interactor.IFeedInteractor
import com.test.enmatest.ui.feed.view.IFeedView
import com.test.enmatest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FeedPresenterImpl<V : IFeedView, I : IFeedInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenterImpl<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), IFeedPresenter<V, I> {
}
