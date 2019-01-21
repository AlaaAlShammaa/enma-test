package com.test.enmatest.ui.home.presenter

import com.test.enmatest.ui.base.presenter.IPresenter
import com.test.enmatest.ui.home.interactor.IHomeInteractor
import com.test.enmatest.ui.home.view.IHomeView

interface IHomePresenter<V : IHomeView, I : IHomeInteractor> : IPresenter<V, I> {
    fun setupBottomNavView()
    fun onSearchClicked()
}
