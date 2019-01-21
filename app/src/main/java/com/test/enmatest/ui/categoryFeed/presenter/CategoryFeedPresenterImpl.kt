package com.test.enmatest.ui.categoryFeed.presenter

import com.test.enmatest.ui.base.presenter.BasePresenterImpl
import com.test.enmatest.ui.categoryFeed.interactor.ICategoryFeedInteractor
import com.test.enmatest.ui.categoryFeed.view.ICategoryFeedView
import com.test.enmatest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CategoryFeedPresenterImpl<V : ICategoryFeedView, I : ICategoryFeedInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenterImpl<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), ICategoryFeedPresenter<V, I> {

}
