package com.test.enmatest.ui.feed.presenter

import com.test.enmatest.data.network.model.Post
import com.test.enmatest.ui.base.presenter.BasePresenterImpl
import com.test.enmatest.ui.feed.adapter.FeedAdapter
import com.test.enmatest.ui.feed.interactor.IFeedInteractor
import com.test.enmatest.ui.feed.view.IFeedView
import com.test.enmatest.util.AppConstants
import com.test.enmatest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FeedPresenterImpl<V : IFeedView, I : IFeedInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenterImpl<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), IFeedPresenter<V, I> {
    var lastPageNumber = 1

    override fun onItemClick(post: Post) {
    }

    override fun getPosts(query: String?) {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getPosts(query, lastPageNumber, AppConstants.PAGE_SIZE)
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({ response ->
                    lastPageNumber++
                    getView()?.hideProgress()
                    getView()?.reflectPosts(response.posts)
                }, { throwable ->
                    throwable.printStackTrace()
                    getView()?.hideProgress()
                })
            )
        }
    }
}
