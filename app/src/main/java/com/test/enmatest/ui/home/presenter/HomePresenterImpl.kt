package com.test.enmatest.ui.home.presenter

import com.test.enmatest.ui.base.presenter.BasePresenterImpl
import com.test.enmatest.ui.home.interactor.IHomeInteractor
import com.test.enmatest.ui.home.view.IHomeView
import com.test.enmatest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomePresenterImpl<V : IHomeView, I : IHomeInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenterImpl<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), IHomePresenter<V, I> {

    override fun setupBottomNavView() {
        getView()?.customizeBottomNavView()
    }
}
