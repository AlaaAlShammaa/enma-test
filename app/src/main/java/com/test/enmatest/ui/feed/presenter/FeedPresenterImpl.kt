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
    private var lastPageNo = 0

    override fun onItemClick(post: Post) {

    }

    override fun getPosts(categoryId: String?, query: String, showSkeletonLoader: Boolean, isNewList: Boolean) {
        if (showSkeletonLoader) {
            getView()?.showProgress()
        } else {
            getView()?.showToolbarProgress()
        }
        interactor?.let {
            compositeDisposable.add(it.getPosts(categoryId, query, lastPageNo, AppConstants.PAGE_SIZE)
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({ response ->
                    lastPageNo++
                    if (showSkeletonLoader) {
                        getView()?.hideProgress()
                    } else {
                        getView()?.hideToolbarProgress()
                    }
                    getView()?.reflectPosts(response.posts, isNewList)
                }, { throwable ->
                    throwable.printStackTrace()
                    if (showSkeletonLoader) {
                        getView()?.hideProgress()
                    } else {
                        getView()?.hideToolbarProgress()
                    }
                })
            )
        }
    }

    override fun setLastPageNumber(lastPageNo: Int) {
        this.lastPageNo = lastPageNo
    }

    override fun getLastPageNumber(): Int = lastPageNo
}
