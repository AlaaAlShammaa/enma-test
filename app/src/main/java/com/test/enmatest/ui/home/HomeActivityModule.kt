package com.test.enmatest.ui.home

import com.test.enmatest.ui.home.interactor.HomeInteractorImpl
import com.test.enmatest.ui.home.interactor.IHomeInteractor
import com.test.enmatest.ui.home.presenter.HomePresenterImpl
import com.test.enmatest.ui.home.presenter.IHomePresenter
import com.test.enmatest.ui.home.view.IHomeView
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    internal fun provideHomeInteractor(HomeInteractorImpl: HomeInteractorImpl): IHomeInteractor = HomeInteractorImpl

    @Provides
    internal fun provideHomePresenter(HomePresenterImpl: HomePresenterImpl<IHomeView, IHomeInteractor>)
            : IHomePresenter<IHomeView, IHomeInteractor> = HomePresenterImpl
}
