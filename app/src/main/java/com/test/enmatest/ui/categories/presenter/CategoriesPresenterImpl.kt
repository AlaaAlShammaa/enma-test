package com.test.enmatest.ui.categories.presenter

import com.test.enmatest.ui.base.presenter.BasePresenterImpl
import com.test.enmatest.ui.categories.interactor.ICategoriesInteractor
import com.test.enmatest.ui.categories.view.ICategoriesView
import com.test.enmatest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CategoriesPresenterImpl<V : ICategoriesView, I : ICategoriesInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenterImpl<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), ICategoriesPresenter<V, I> {
    override fun loadCategories() {
        interactor?.let {
            compositeDisposable.add(it.getCategories()
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({response ->

                },{throwable ->

                }))
        }
    }
}
