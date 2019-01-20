package com.test.enmatest.ui.categories.presenter

import com.test.enmatest.ui.base.presenter.IPresenter
import com.test.enmatest.ui.categories.interactor.ICategoriesInteractor
import com.test.enmatest.ui.categories.view.ICategoriesView

interface ICategoriesPresenter<V : ICategoriesView, I : ICategoriesInteractor> : IPresenter<V, I> {
}
